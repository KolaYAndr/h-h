package com.example.myapplication.data.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class Product(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("badge")
    val badge: List<Badge>,
    @SerializedName("department")
    val department: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("sizes")
    val sizes: List<Size>,
    @SerializedName("details")
    val details: List<String>,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("preview")
    val preview: String,
)