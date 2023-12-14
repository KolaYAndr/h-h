package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.data.product.Product
import com.example.myapplication.db.converters.BadgesConverter
import com.example.myapplication.db.converters.ListOfStringConverter
import com.example.myapplication.db.converters.SizesConverter
import com.example.myapplication.db.dao.ProductDAO

@TypeConverters(
    BadgesConverter::class,
    SizesConverter::class,
    ListOfStringConverter::class
)
@Database(entities = [Product::class], version = 1)
abstract class ProductDataBase : RoomDatabase() {
    abstract fun getProductDAO(): ProductDAO
}