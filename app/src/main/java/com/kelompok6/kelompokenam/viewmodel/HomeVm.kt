package com.kelompok6.kelompokenam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.play.integrity.internal.l
import com.kelompok6.kelompokenam.model.data_productItem
import com.kelompok6.kelompokenam.model.news_update_dataItem
import com.kelompok6.kelompokenam.model.slider_dataItem
import com.kelompok6.kelompokenam.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeVm : ViewModel(){
    var liveDataSlider: MutableLiveData<List<slider_dataItem>>
    var liveDataNews: MutableLiveData<List<news_update_dataItem>>
    var liveDataNewsDetail : MutableLiveData<news_update_dataItem> = MutableLiveData()
    val news : LiveData<news_update_dataItem> get() = liveDataNewsDetail
    var liveDataProduct : MutableLiveData<List<data_productItem>>
    init {
        liveDataSlider = MutableLiveData()
        liveDataNews = MutableLiveData()
        liveDataProduct = MutableLiveData()
    }
    fun getDataSlider(){
        //memakai callback yang retrofit
        RetrofitClient.instance.getSliders().enqueue(object : Callback<List<slider_dataItem>> {
            override fun onResponse(
                call: Call<List<slider_dataItem>>,
                response: Response<List<slider_dataItem>>
            ) {
                if (response.isSuccessful){
                    liveDataSlider.postValue(response.body())
                }else{
                    liveDataSlider.postValue(emptyList())
                }
            }

            override fun onFailure(call: Call<List<slider_dataItem>>, t: Throwable) {
                liveDataSlider.postValue(emptyList())
            }

        })
    }
    fun getDataNews(){
        //memakai callback yang retrofit
        RetrofitClient.instance.getNews().enqueue(object : Callback<List<news_update_dataItem>> {
            override fun onResponse(
                call: Call<List<news_update_dataItem>>,
                response: Response<List<news_update_dataItem>>

            ) {
                if (response.isSuccessful){
                    liveDataNews.postValue(response.body())
//                    val newsresponse = response.body()
//                    liveDataNews.postValue(newsresponse!!)
                }else{
                    liveDataNews.postValue(emptyList())
//                    liveDataNews.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<news_update_dataItem>>, t: Throwable) {
                liveDataNews.postValue(emptyList())
//                liveDataNews.value = emptyList()
            }

        })
    }
    fun getDataProduct(){
        //memakai callback yang retrofit
        RetrofitClient.instance.getProduct().enqueue(object : Callback<List<data_productItem>> {
            override fun onResponse(
                call: Call<List<data_productItem>>,
                response: Response<List<data_productItem>>

            ) {
                if (response.isSuccessful){
                    liveDataProduct.postValue(response.body())
//                    val newsresponse = response.body()
//                    liveDataNews.postValue(newsresponse!!)
                }else{
                    liveDataProduct.postValue(emptyList())
//                    liveDataNews.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<data_productItem>>, t: Throwable) {
                liveDataProduct.postValue(emptyList())
//                liveDataNews.value = emptyList()
            }

        })
    }
    fun getNewsDetail(newsId:Int) {
        RetrofitClient.instance.getNewsDetail(newsId.toString())
            .enqueue(object : Callback<news_update_dataItem> {
                override fun onResponse(call: Call<news_update_dataItem>, response: Response<news_update_dataItem>) {
                    if (response.isSuccessful) {
                        val news = response.body()
                        liveDataNewsDetail.value = news!!
                    }
                }

                override fun onFailure(call: Call<news_update_dataItem>, t: Throwable) {
                    liveDataNews.value = emptyList()
                }

            })
    }
}