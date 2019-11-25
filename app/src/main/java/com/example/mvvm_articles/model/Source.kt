package com.example.mvvm_articles.model

import com.squareup.moshi.Json

class Source {
    var id: String? = null
    @Json(name = "name")
    var name: String? = null

}