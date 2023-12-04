package com.example.myapplication.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.product.Product

@Dao
interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query("SELECT * FROM products")
    suspend fun getAllProducts() : List<Product>

    @Query("SELECT * FROM products WHERE id=:id")
    suspend fun getProduct(id: String) : Product
}