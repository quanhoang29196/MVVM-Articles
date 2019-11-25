package com.example.mvvm_articles.rest

import com.example.mvvm_articles.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines/com.example.mvvm_articles.model.Respons")
    fun getNewsList(@Query("apiKey") apiKey: String?): Call<NewsResponse?>?
}