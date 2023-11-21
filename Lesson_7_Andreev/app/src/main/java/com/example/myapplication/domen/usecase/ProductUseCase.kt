package com.example.myapplication.domen.usecase

import com.example.myapplication.data.product.Product
import com.example.myapplication.data.repository.AccessRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val repository: AccessRepository,
) {
    suspend fun getProducts() : List<Product> {
        return repository.getProducts()
    }
}