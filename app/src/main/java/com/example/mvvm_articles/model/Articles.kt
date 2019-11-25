package com.example.mvvm_articles.model

import com.squareup.moshi.Json

class Articles {
    @Json(name = "source")
    var source: Source? = null
    @Json(name = "author")
    var author: String? = null
    @Json(name = "title")
    var title: String? = null
    @Json(name = "description")
    var description: String? = null
    @Json(name = "url")
    var url: String? = null
    @Json(name = "urlToImage")
    var urlToImage: String? = null
    @Json(name = "publishedAt")
    var publishedAt: String? = null
    @Json(name = "content")
    var content: String? = null

}