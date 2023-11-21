package com.example.myapplication.data.product

import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("isAvailable")
    val isAvailable: String,
    @SerializedName("value")
    val value: String
)