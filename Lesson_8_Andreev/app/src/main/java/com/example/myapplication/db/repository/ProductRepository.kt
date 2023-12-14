package com.example.myapplication.db.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.product.Product
import com.example.myapplication.db.ProductDataBase
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDataBase: ProductDataBase
) {
    suspend fun getAllProducts() = productDataBase.getProductDAO().getAllProducts()

    suspend fun getProduct(id: String) = productDataBase.getProductDAO().getProduct(id)

    suspend fun addProducts(products: List<Product>) =
        productDataBase.getProductDAO().addProducts(products)

}