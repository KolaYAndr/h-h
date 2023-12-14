package com.example.myapplication.data.product

import com.google.gson.annotations.SerializedName

data class OrderProduct (
    @SerializedName("ProductId")
    val id: String,
    @SerializedName("Size")
    val size: String,
    @SerializedName("Quantity")
    val quantity: Int
)