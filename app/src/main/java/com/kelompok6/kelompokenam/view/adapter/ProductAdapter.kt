package com.kelompok6.kelompokenam.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kelompok6.databinding.ItemNewsBinding
import com.kelompok6.databinding.ItemProductBinding
import com.kelompok6.kelompokenam.model.data_productItem
import com.kelompok6.kelompokenam.model.news_update_dataItem

class ProductAdapter (var listProduct : List<data_productItem>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.judul.text =  listProduct[position].name
        holder.binding.price.text = "Rp." + listProduct[position].price
        Glide.with(holder.itemView).load(listProduct[position].productImage).into(holder.binding.newsPoster)

    }
    override fun getItemCount(): Int {
        return listProduct.size
    }
}