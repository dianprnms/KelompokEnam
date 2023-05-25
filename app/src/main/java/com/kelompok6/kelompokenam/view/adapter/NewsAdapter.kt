package com.kelompok6.kelompokenam.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kelompok6.databinding.ItemNewsBinding
import com.kelompok6.kelompokenam.model.news_update_dataItem

class NewsAdapter (var listNews : List<news_update_dataItem>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.judul.text = listNews[position].title
        Glide.with(holder.itemView).load(listNews[position].newsImage).into(holder.binding.newsPoster)

    }
    override fun getItemCount(): Int {
        return listNews.size
    }
}