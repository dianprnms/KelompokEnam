package com.kelompok6.kelompokenam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelompok6.kelompokenam.model.news_update_dataItem
import com.kelompok6.kelompokenam.model.slider_dataItem
import com.kelompok6.kelompokenam.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeVm : ViewModel(){
    lateinit var liveDataSlider: MutableLiveData<List<slider_dataItem>>
    lateinit var liveDataNews: MutableLiveData<List<news_update_dataItem>>
    init {
        liveDataSlider = MutableLiveData()
        liveDataNews = MutableLiveData()
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
                    val newsresponse = response.body()
                    liveDataNews.postValue(newsresponse!!)
                }else{
                    liveDataNews.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<news_update_dataItem>>, t: Throwable) {
                liveDataNews.value = emptyList()
            }

        })
    }
}