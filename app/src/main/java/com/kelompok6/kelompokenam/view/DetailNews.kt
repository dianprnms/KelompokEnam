package com.kelompok6.kelompokenam.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.play.integrity.internal.m
import com.kelompok6.databinding.FragmentDetailBinding
import com.kelompok6.databinding.FragmentDetailNewsBinding
import com.kelompok6.kelompokenam.model.news_update_dataItem
import com.kelompok6.kelompokenam.viewmodel.HomeVm

class DetailNews : Fragment() {
    lateinit var binding: FragmentDetailNewsBinding
    lateinit var viewModel:HomeVm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailNewsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getNews = requireArguments().getInt("id", 0)
        viewModel = ViewModelProvider(this)[HomeVm::class.java]
        viewModel.liveDataNewsDetail.observe(viewLifecycleOwner) {news ->
            bindMovieData(news)
        }

        viewModel.getNewsDetail(getNews)

    }
    private fun bindMovieData(news: news_update_dataItem) {
        viewModel.news.observe(viewLifecycleOwner) {
            binding.apply {
                Glide.with(this@DetailNews)
                    .load(news.newsImage)
                    .into(imgDetailNews)
                judul.text = news.title
                Content.text = news.content
            }
        }
    }
}