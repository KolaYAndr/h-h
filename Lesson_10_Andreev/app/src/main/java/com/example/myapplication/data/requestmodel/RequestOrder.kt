package com.example.myapplication.data.requestmodel

import com.example.myapplication.data.product.OrderProduct
import com.google.gson.annotations.SerializedName

data class RequestOrder(
    @SerializedName("House") val house: String,
    @SerializedName("Apartment") val apartment: String,
    @SerializedName("DateDelivery") val date: String,
    @SerializedName("Products") val products: List<OrderProduct>
)