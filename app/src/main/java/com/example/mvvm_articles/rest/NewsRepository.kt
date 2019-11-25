package com.example.mvvm_articles.rest

import com.example.mvvm_articles.model.NewsResponse
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val newsApi: NewsApi
    fun getNews(key: String?): MutableLiveData<NewsResponse> {
        val newsData = MutableLiveData<NewsResponse>()
        newsApi.getNewsList(key)!!.enqueue(object : Callback<NewsResponse?> {
            override fun onResponse(call: Call<NewsResponse?>,
                                    response: Response<NewsResponse?>
            ) {
                if (response.isSuccessful) {
                    newsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<NewsResponse?>, t: Throwable) {
                newsData.value = null
            }
        })
        return newsData
    }

    companion object {
        private var newsRepository: NewsRepository? = null
        @JvmStatic
        val instance: NewsRepository?
            get() {
                if (newsRepository == null) {
                    newsRepository = NewsRepository()
                }
                return newsRepository
            }
    }

    init {
        newsApi = RetrofitService.cteateService(NewsApi::class.java)
    }
}