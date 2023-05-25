package com.kelompok6.kelompokenam.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.slider.Slider
import com.kelompok6.databinding.ItemSliderBinding
import com.kelompok6.kelompokenam.model.slider_dataItem

class SliderAdapter (var listSlider : List<slider_dataItem>) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemSliderBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(listSlider[position].image).into(holder.binding.imageSlider)

    }
    override fun getItemCount(): Int {
            return listSlider.size
    }
}