package com.kelompok6.kelompokenam.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.datatransport.runtime.util.PriorityMapping.toInt
import com.kelompok6.R
import com.kelompok6.databinding.ItemNewsBinding
import com.kelompok6.kelompokenam.model.news_update_dataItem

class NewsAdapter (var listNews : List<news_update_dataItem>,
var onItemClick: ((news_update_dataItem) -> Unit)? = null) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindNews(itemNews: news_update_dataItem) {
            binding.judul.text = itemNews.title
            Glide.with(itemView).load(itemNews.newsImage).into(binding.newsPoster)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindNews(listNews[position])
        holder.binding.cv.setOnClickListener{
            onItemClick?.invoke(listNews[position])
        }

    }
    override fun getItemCount(): Int {
        return listNews.size
    }
}