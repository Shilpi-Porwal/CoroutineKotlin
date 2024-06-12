package com.example.coroutinekotlin.Interface

import com.example.coroutinekotlin.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>
}