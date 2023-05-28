package com.kelompok6.kelompokenam.network

import com.kelompok6.kelompokenam.model.data_productItem
import com.kelompok6.kelompokenam.model.news_update_dataItem
import com.kelompok6.kelompokenam.model.slider_dataItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestfulApi {
    @GET("sliders")
    fun getSliders():Call<List<slider_dataItem>>
    @GET("news_update")
    fun getNews():Call<List<news_update_dataItem>>
    @GET("news_updaet/{id}")
    fun getNewsDetail(
        @Path("id") newsId: String
    ):Call<news_update_dataItem>

    @GET("category_product/4/products")
    fun getProduct():Call<List<data_productItem>>
}