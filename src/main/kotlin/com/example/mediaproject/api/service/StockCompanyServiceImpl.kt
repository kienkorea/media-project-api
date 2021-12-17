package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.CompanyRequest
import com.example.mediaproject.api.response.*
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.BookmarkedCompany
import com.example.mediaproject.db.entity.Company
import com.example.mediaproject.db.entity.companyOf
import com.example.mediaproject.db.repository.BookmarkedCompanyRepository
import com.example.mediaproject.db.repository.CompanyRepository
import com.example.mediaproject.db.repository.CompanyRepositorySupport
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import retrofit2.Response
import java.lang.Integer.min
import javax.transaction.Transactional
import kotlin.streams.toList


@Service
class StockCompanyServiceImpl(
    private val naverStockPriceService: NaverStockPriceService,
    private val companyRepository: CompanyRepository,
    private val companyRepositorySupport: CompanyRepositorySupport,
    private val bookmarkedCompanyRepository: BookmarkedCompanyRepository
) : StockCompanyService {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    private val baseUrl: String = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query="
    private val imageBaseUrl = "http://5c4c-182-227-161-146.ngrok.io/media-project/up-down/stocks/image/"

    override fun getCompanyStockData(q: String?, userId: Long): List<CompanyResponse> {
        val bookmarkedCompanyList: MutableList<BookmarkedCompany> = bookmarkedCompanyRepository.findAllByUserId(userId)

        val companyList: List<Company> = companyRepositorySupport.getAllCompanyWithQ(q)

        val naverStockItemList: MutableList<NaverStockItem> = mutableListOf()
        var idx = 0
        while (idx <= companyList.size) {
            naverStockItemList.addAll(
                this.requestToNaverStock(
                    companyList.subList(
                        idx,
                        min(idx + 15, companyList.size)
                    )
                )
            )
            idx += 15
        }

        bookmarkedCompanyList.forEach { bookmarkedCompany ->
            naverStockItemList.filter { it.itemcode == bookmarkedCompany.company.companyCode }.forEach { item -> item.isBookmarked = true }
        }

        return naverStockItemList.map { company ->
            var companyImageUrl: String = ""
            companyList.forEach {
                if (company.itemcode == it.companyCode)
                    companyImageUrl = "$imageBaseUrl${it.companyCode}"
            }
            companyResponseOf(company, requestNewsToNaver(company.itemname + " 주식"), companyImageUrl)
        }.sortedBy { it.stockPrice }.toList()
    }

    override fun feedCompanyStockData(nextId: Long): List<CompanyResponse> {
        TODO("Not yet implemented")
    }

    private fun requestToNaverStock(companyList: List<Company>): List<NaverStockItem> {
        val stringBuilder = StringBuilder("naver_stock_codeList=")
        companyList.forEach { stringBuilder.append(it.companyCode + "%7C") }

        val response: Response<NaverStockResponse> =
            naverStockPriceService.getStockPrice(stringBuilder.toString()).execute()
        return response.body()?.item_list ?: listOf()
    }

    override fun postCompany(companyRequest: CompanyRequest): Company {
        if (companyRepository.existsByName(companyRequest.name))
            throw BadRequestException("해당 주식 회사 이름이 존재합니다. ->${companyRequest.name}")
        return companyRepository.save(companyOf(companyRequest))
    }

    override fun getCompanyStockDataDetail(companyCode: String): List<CompanyResponse> {
        val companyList: List<Company> = companyRepository.findAllByCompanyCode(companyCode)
        if (companyList.isNotEmpty()) {
            val naverStockItemList: List<NaverStockItem> = requestToNaverStock(companyList)
            val naverNewsResponseList: List<NaverNewsResponse> = requestNewsToNaver(companyList[0].name + " 주식")
            return naverStockItemList.map { companyResponseOf(it, naverNewsResponseList) }
        }
        return mutableListOf()
    }

    @Transactional
    override fun postCompanyList(companyRequestList: List<CompanyRequest>): List<Company> {
        return companyRequestList.stream().map { this.postCompany(it) }.toList()
    }

    override fun getCompanyImage(companyCode: String): ResponseEntity<ByteArray> {
        val byteArray = ResourceUtils.getFile("classpath:company_image/$companyCode.png")
        val header = HttpHeaders().apply {
            contentType = MediaType.IMAGE_PNG
            contentLength = byteArray.length()
        }
        return ResponseEntity(byteArray.readBytes(), header, HttpStatus.OK)
    }

    private fun requestNewsToNaver(keyword: String): List<NaverNewsResponse> {
        val doc: Document = Jsoup.connect("$baseUrl $keyword").get()
        val elements = doc.select("ul.list_news > li")
        val naverNewsResponseList: MutableList<NaverNewsResponse> = mutableListOf()
        var title = ""
        var newsUrl = ""
        var imageUrl = ""
        elements.forEach {
            if (it.select("a.news_tit").isNotEmpty()) {
                val aTag = it.select("a.news_tit")[0]
                title = aTag.text() // title
                newsUrl = aTag.attr("href") //newsUrl
                if (it.select("a.dsc_thumb > img").isNotEmpty()) {
                    val imgTag = it.select("a.dsc_thumb > img")[0]
                    imageUrl = imgTag.attr("src") // imageUrl
//                    logger.info("Title: $title: ———> Link: $newsUrl ——> Image: $imageUrl")
                }
                naverNewsResponseList.add(NaverNewsResponse(title, newsUrl, imageUrl))
            }
        }
        return naverNewsResponseList
    }

}