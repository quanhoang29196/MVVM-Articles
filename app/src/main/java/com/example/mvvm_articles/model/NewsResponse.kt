package com.example.mvvm_articles.model

import com.squareup.moshi.Json

class NewsResponse {
    @Json(name = "status")
    var status: String? = null
    @Json(name = "totalResults")
    var totalResults: Int? = null
    @Json(name = "articles")
    var articles: List<Articles>? = null

}