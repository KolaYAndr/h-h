package com.example.myapplication.domain.usecase

import com.example.myapplication.data.product.Product
import com.example.myapplication.data.repository.AccessRepository
import com.example.myapplication.db.repository.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val accessRepository: AccessRepository,
    private val productRepository: ProductRepository
) {
    suspend fun getProducts(pageSize: Int) = productRepository.getAllProducts().ifEmpty {
        val products = accessRepository.getProducts(pageSize)
        productRepository.addProducts(products)
        products
    }

    suspend fun getProduct(id: String): Product {
        val dbData = productRepository.getProduct(id)
        return if (dbData.title == "") {
            val product = accessRepository.getProduct(id)
            productRepository.addProducts(listOf(product))
            product
        } else dbData
    }
}