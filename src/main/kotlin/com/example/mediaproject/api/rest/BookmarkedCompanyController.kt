package com.example.mediaproject.api.rest

import com.example.mediaproject.api.response.BookmarkedCompanyResponse
import com.example.mediaproject.api.service.BookmarkedCompanyService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/media-project/up-down/bookmark-companies")
class BookmarkedCompanyController(
    private val bookmarkedCompanyService: BookmarkedCompanyService
) {

    @ApiOperation("관심 회사 추가하기")
    @PostMapping
    fun postBookmarkedCompany(
        @RequestAttribute userId: Long,
        @RequestParam companyCode: String,
    ): ResponseEntity<BookmarkedCompanyResponse> {
        val response = bookmarkedCompanyService.postBookmarkedCompany(userId, companyCode)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{bookMarkedId}")
    fun deleteBookMarkedCompany(
        @PathVariable bookMarkedId: Long
    ): ResponseEntity<Boolean> {
        val response = bookmarkedCompanyService.deleteBookMarkedCompany(bookMarkedId)
        return ResponseEntity.ok(response)
    }

}