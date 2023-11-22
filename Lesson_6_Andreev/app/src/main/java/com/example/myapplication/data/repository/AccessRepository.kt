package com.example.myapplication.data.repository

import com.example.myapplication.data.ApiLesson
import com.example.myapplication.data.requestmodel.RequestLogin
import com.example.myapplication.data.responcemodel.ResponseLogin
import javax.inject.Inject

class AccessRepository @Inject constructor(
    private val apiLesson: ApiLesson,
) {
    suspend fun login(email: String, password: String): ResponseLogin {
        return apiLesson.login(RequestLogin(email, password)).data
    }
}