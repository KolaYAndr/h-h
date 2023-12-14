package com.example.myapplication.data.product

import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("color")
    val color: String,
    @SerializedName("value")
    val value: String
)