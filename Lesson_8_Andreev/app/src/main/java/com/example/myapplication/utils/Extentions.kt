package com.example.myapplication.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.data.responcemodel.ErrorBaseResponse
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.HttpException

fun Exception.getError():String? =
    if (this is HttpException){
        Gson().fromJson(response()?.errorBody()?.string(), ErrorBaseResponse::class.java).error.message
    }else{
        message
    }

fun View.makeSnackBar(message:String): Snackbar =
    Snackbar
        .make(this, message, Snackbar.LENGTH_LONG)
        .setBackgroundTint(ContextCompat.getColor(context, R.color.text_field_error))
        .setTextColor(ContextCompat.getColor(context, R.color.white))