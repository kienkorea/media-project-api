package com.example.mediaproject.api.service

import com.example.mediaproject.api.request.CompanyRequest
import com.example.mediaproject.api.response.*
import com.example.mediaproject.common.exception.BadRequestException
import com.example.mediaproject.db.entity.Company
import com.example.mediaproject.db.entity.companyOf
import com.example.mediaproject.db.repository.CompanyRepository
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import retrofit2.Response


@Service
class StockCompanyServiceImpl(
    private val naverStockPriceService: NaverStockPriceService,
    private val companyRepository: CompanyRepository
) : StockCompanyService {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    private val baseUrl: String = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query="

    override fun getCompanyStockData(pageable: Pageable): List<CompanyResponse> {
        val companyList: List<Company> = companyRepository.findAll()

        val naverStockItemList: List<NaverStockItem> = requestToNaverStock(companyList)

        return naverStockItemList.map { companyResponseOf(it) }
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
        if(companyList.isNotEmpty()) {
            val naverStockItemList: List<NaverStockItem> = requestToNaverStock(companyList)
            val naverNewsResponseList: List<NaverNewsResponse> = requestNewsToNaver(companyList[0].name + " 주식")
            return naverStockItemList.map { companyResponseOf(it, naverNewsResponseList) }
        }
        return mutableListOf()
    }

    private fun requestNewsToNaver(keyword: String): List<NaverNewsResponse> {
        val doc: Document = Jsoup.connect("$baseUrl $keyword").get()
        val elements = doc.select("ul.list_news > li")
        val naverNewsResponseList: MutableList<NaverNewsResponse> = mutableListOf()
        var title = ""
        var newsUrl = ""
        var imageUrl = ""
        elements.forEach {
            if(it.select("a.news_tit").isNotEmpty()) {
                val aTag = it.select("a.news_tit")[0]
                title = aTag.text() // title
                newsUrl = aTag.attr("href") //newsUrl
                if (it.select("a.dsc_thumb > img").isNotEmpty()) {
                    val imgTag = it.select("a.dsc_thumb > img")[0]
                    imageUrl = imgTag.attr("src") // imageUrl
                    logger.info("Title: $title: ———> Link: $newsUrl ——> Image: $imageUrl")
                }
                naverNewsResponseList.add(NaverNewsResponse(title, newsUrl, imageUrl))
            }
        }
        return naverNewsResponseList
    }

    // 지금 사용하지 않음
//    private fun requestDetailToNaverStock(company: Company): NaverStockItem {
//        val stringBuilder = StringBuilder("naver_stock_codeList=")
//        stringBuilder.append(company.companyCode + "%7C")
//        val response: Response<NaverStockItem> =
//            naverStockPriceService.getOneStockDetail(stringBuilder.toString()).execute()
//        return response.body() ?: throw NotFoundException("주식 회사 정보를 찾을 수 없습니다. -> ${company.companyCode}")
//    }
}