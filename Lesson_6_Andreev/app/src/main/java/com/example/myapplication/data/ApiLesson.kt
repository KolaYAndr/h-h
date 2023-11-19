package com.example.myapplication.data

import com.example.myapplication.data.requestmodel.RequestLogin
import com.example.myapplication.data.responcemodel.BaseResponse
import com.example.myapplication.data.responcemodel.ResponseLogin
import retrofit2.http.Body
import retrofit2.http.PUT

interface ApiLesson {
    @PUT("user/signin")
    suspend fun login(
        @Body requestLogin: RequestLogin,
    ): BaseResponse<ResponseLogin>
}