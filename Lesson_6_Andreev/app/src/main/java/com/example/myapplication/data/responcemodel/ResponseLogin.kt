package com.example.myapplication.data.responcemodel

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("profile") val profile: ResponseProfile,
)