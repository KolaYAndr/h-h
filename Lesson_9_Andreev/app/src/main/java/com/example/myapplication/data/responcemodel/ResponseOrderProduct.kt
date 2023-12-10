package com.example.myapplication.data.responcemodel

import com.google.gson.annotations.SerializedName

data class ResponseOrderProduct(
    @SerializedName("productId")
    val id: String,
    @SerializedName("preview")
    val imageUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("price")
    val price: Int
)