package com.example.myapplication.domain.usecase

import com.example.myapplication.data.product.OrderProduct
import com.example.myapplication.data.repository.AccessRepository
import javax.inject.Inject

class OrderUseCase @Inject constructor(
    private val accessRepository: AccessRepository
) {
    suspend fun order(
        house: String,
        apartment: String,
        date: String,
        products: List<OrderProduct>
    ) = accessRepository.order(house, apartment, date, products)
}