package com.example.myapplication.data.product

import com.google.gson.annotations.SerializedName

class Size(
    @SerializedName("isAvailable")
    val isAvailable: Boolean,
    @SerializedName("value")
    val value: String
){
    override fun toString(): String {
        return value
    }
}