package com.kelompok6.kelompokenam.network

import com.kelompok6.kelompokenam.model.news_update_dataItem
import com.kelompok6.kelompokenam.model.slider_dataItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("sliders")
    fun getSliders():Call<List<slider_dataItem>>
    @GET("news_update")
    fun getNews():Call<List<news_update_dataItem>>
}