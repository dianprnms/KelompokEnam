package com.kelompok6.kelompokenam.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.databinding.FragmentHomeBinding
import com.kelompok6.kelompokenam.model.news_update_dataItem
import com.kelompok6.kelompokenam.view.adapter.NewsAdapter
import com.kelompok6.kelompokenam.view.adapter.SliderAdapter
import com.kelompok6.kelompokenam.viewmodel.HomeVm


class Home : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModelHomeVm: HomeVm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSlider()
        getNews()
    }
    fun getSlider(){
        viewModelHomeVm = ViewModelProvider(this).get(HomeVm::class.java)
        viewModelHomeVm.getDataSlider()
        viewModelHomeVm.liveDataSlider.observe(viewLifecycleOwner, Observer{
            binding.viewpager.adapter = SliderAdapter(it)
        })
    }
    @SuppressLint("NotifyDataSetChanged")
    fun getNews(){
        viewModelHomeVm = ViewModelProvider(this).get(HomeVm::class.java)
        viewModelHomeVm.getDataNews()
        viewModelHomeVm.liveDataNews.observe(viewLifecycleOwner, Observer{
            binding.rvconNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvconNews.adapter = NewsAdapter(it)
        })
    }

}