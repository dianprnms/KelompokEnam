package com.kelompok6.kelompokenam.model


import com.google.gson.annotations.SerializedName

data class slider_dataItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String
)