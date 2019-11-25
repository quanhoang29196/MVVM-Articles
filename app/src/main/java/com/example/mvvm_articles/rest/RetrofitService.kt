package com.example.mvvm_articles.rest

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun <S> cteateService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}