package com.example.mvvm_articles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_articles.R
import com.example.mvvm_articles.model.Articles
import com.squareup.picasso.Picasso

class RecyclerviewAdapter(var context: Context,  articles: ArrayList<Articles>, listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerviewAdapter.NewsViewHolder>() {

    private val articles:ArrayList<Articles>
    private val listener:OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(articles: ArrayList<Articles>)
    }

    init {
        this.articles = articles
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.article_row, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       holder.bind(articles,listener)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var articleTitle: TextView
        var articleAuthor: TextView
        var articleDescription: TextView
        var articleImage: ImageView

        init {
            articleTitle = itemView.findViewById(R.id.Title)
            articleAuthor = itemView.findViewById(R.id.Author)
            articleDescription = itemView.findViewById(R.id.Description)
            articleImage = itemView.findViewById(R.id.Image)
        }
        fun bind(articles: ArrayList<Articles>, listener:OnItemClickListener) {
            articleTitle.text = articles[position].title.toString()
            articleAuthor.text = articles[position].toString()
            articleDescription.text = articles[position].toString()
            Picasso.get().load(articles[position].urlToImage).into(articleImage)
            itemView.setOnClickListener(object:View.OnClickListener {
                override fun onClick(v:View) {
                    listener.onItemClick(articles)
                }
            })
        }
    }

}