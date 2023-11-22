package com.example.myapplication.data.responcemodel

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("data") val data: T,
)