package com.example.mvvm_articles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_articles.adapter.RecyclerviewAdapter
import com.example.mvvm_articles.model.Articles
import com.example.mvvm_articles.model.NewsResponse
import com.example.mvvm_articles.viewmodel.BaseViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    var articleArrayList = ArrayList<Articles>()
    var recyclerviewAdapter: RecyclerviewAdapter? = null
    var recyclerView: RecyclerView? = null
    var baseViewModel: BaseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        baseViewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)
        baseViewModel!!.init()
        baseViewModel!!.newsRepository.observe(this, Observer { newsResponse: NewsResponse ->
            val articlesList = newsResponse.articles
            articleArrayList.addAll(articlesList!!)
            recyclerviewAdapter!!.notifyDataSetChanged()
        })
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        if (recyclerviewAdapter == null) {
            recyclerviewAdapter = RecyclerviewAdapter(this@MainActivity, articleArrayList)
            recyclerView!!.layoutManager = LinearLayoutManager(this)
            recyclerView!!.adapter = recyclerviewAdapter
            recyclerView!!.itemAnimator = DefaultItemAnimator()
            recyclerView!!.isNestedScrollingEnabled = true
        } else {
            recyclerviewAdapter!!.notifyDataSetChanged()
        }
    }
}
