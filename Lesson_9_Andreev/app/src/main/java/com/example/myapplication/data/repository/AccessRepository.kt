package com.example.myapplication.data.repository

import com.example.myapplication.data.ApiLesson
import com.example.myapplication.data.product.OrderProduct
import com.example.myapplication.data.requestmodel.RequestLogin
import com.example.myapplication.data.requestmodel.RequestOrder
import com.example.myapplication.data.responcemodel.ResponseLogin
import com.example.myapplication.data.responcemodel.ResponseOrder
import javax.inject.Inject

class AccessRepository @Inject constructor(
    private val apiLesson: ApiLesson,
) {
    suspend fun login(email: String, password: String): ResponseLogin =
        apiLesson.login(RequestLogin(email, password)).data


    suspend fun getProducts(pageSize: Int) = apiLesson.getProducts(pageSize).data
    suspend fun getProduct(id: String) = apiLesson.getProduct(id).data

    suspend fun order(
        house: String,
        apartment: String,
        date: String,
        products: List<OrderProduct>
    ): ResponseOrder = apiLesson.order(RequestOrder(house, apartment, date, products)).data
}