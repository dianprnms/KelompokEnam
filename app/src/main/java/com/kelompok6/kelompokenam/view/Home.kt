package com.kelompok6.kelompokenam.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.R
import com.kelompok6.databinding.FragmentHomeBinding
import com.kelompok6.kelompokenam.view.adapter.NewsAdapter
import com.kelompok6.kelompokenam.view.adapter.ProductAdapter
import com.kelompok6.kelompokenam.view.adapter.SliderAdapter
import com.kelompok6.kelompokenam.viewmodel.HomeVm
import okhttp3.internal.notify


class Home : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModelHomeVm: HomeVm
    lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSlider()
        getNews()
        getProduct()
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
        newsAdapter = NewsAdapter(emptyList()){news ->
            val bundle = Bundle()
            bundle.putInt("id", news.idNews.toInt())
            findNavController().navigate(R.id.action_home2_to_detailNews, bundle)
        }
        viewModelHomeVm = ViewModelProvider(this).get(HomeVm::class.java)
        viewModelHomeVm.getDataNews()
        binding.rvconNews.adapter = newsAdapter
        binding.rvconNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModelHomeVm.liveDataNews.observe(viewLifecycleOwner, Observer{
            newsAdapter.listNews = it
            newsAdapter.notifyDataSetChanged()
        })
    }
    fun getProduct(){
        viewModelHomeVm = ViewModelProvider(this).get(HomeVm::class.java)
        viewModelHomeVm.getDataProduct()
        viewModelHomeVm.liveDataProduct.observe(viewLifecycleOwner, Observer{
            binding.rvProduct.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.rvProduct.adapter = ProductAdapter(it)
        })
    }

}