package com.example.myapplication.data.product

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("badge")
    val badge: List<Badge>,
    @SerializedName("department")
    val department: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("details")
    val details: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("preview")
    val preview: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("sizes")
    val sizes: List<Size>,
    @SerializedName("title")
    val title: String
)