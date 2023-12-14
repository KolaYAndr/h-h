package com.example.myapplication.data.responcemodel

import com.google.gson.annotations.SerializedName

data class ResponseOrder(
    @SerializedName("createdDelivery")
    val createdDelivery: String,
    @SerializedName("dateDelivery")
    val dateDelivery: String,
    @SerializedName("deliveryAddress")
    val deliveryAddress: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("products")
    val products: List<ResponseOrderProduct>,
    @SerializedName("status")
    val status: String
)