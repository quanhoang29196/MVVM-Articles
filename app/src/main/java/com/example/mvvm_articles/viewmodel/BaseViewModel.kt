package com.example.mvvm_articles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_articles.model.NewsResponse
import com.example.mvvm_articles.rest.NewsRepository
import com.example.mvvm_articles.rest.NewsRepository.Companion.instance


class BaseViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<NewsResponse>? = null
    var newsRepository: NewsRepository? = null
    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsRepository = instance
        mutableLiveData = newsRepository!!.getNews("API_Key")
    }

    fun getNewsRepository(): LiveData<NewsResponse?>? {
        return mutableLiveData
    }
}