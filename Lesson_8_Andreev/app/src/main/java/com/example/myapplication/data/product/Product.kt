package com.example.myapplication.data.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "products")
data class Product(
    @ColumnInfo(name = "badges")
    @SerializedName("badge")
    val badge: List<Badge>,
    @ColumnInfo(name = "department")
    @SerializedName("department")
    val department: String,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,
    @SerializedName("details")
    val details: List<String>,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "images")
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("preview")
    val preview: String,
    @ColumnInfo(name = "price")
    @SerializedName("price")
    val price: Int,
    @ColumnInfo(name = "sizes")
    @SerializedName("sizes")
    val sizes: List<Size>,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String
)