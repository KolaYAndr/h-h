package com.example.myapplication.data.repository

import com.example.myapplication.data.ApiLesson
import com.example.myapplication.data.product.Product
import com.example.myapplication.data.requestmodel.RequestLogin
import com.example.myapplication.data.responcemodel.ResponseLogin
import javax.inject.Inject

class AccessRepository @Inject constructor(
    private val apiLesson: ApiLesson,
) {
    suspend fun login(email: String, password: String): ResponseLogin {
        return apiLesson.login(RequestLogin(email, password)).data
    }

    suspend fun getProducts(pageSize: Int) : List<Product>{
        return apiLesson.getProducts(pageSize).data
    }

    suspend fun getProduct(id: String) : Product = apiLesson.getProduct(id).data
}