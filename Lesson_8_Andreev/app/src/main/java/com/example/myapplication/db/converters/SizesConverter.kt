package com.example.myapplication.db.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.myapplication.data.product.Size
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class SizesConverter {
    @TypeConverter
    fun fromSizeList(sizeList: List<Size>): String {
        val gson = Gson()
        return gson.toJson(sizeList)
    }

    @TypeConverter
    fun toSizeList(sizeListString: String): List<Size> {
        val gson = Gson()
        val type = object : TypeToken<List<Size>>() {}.type
        return gson.fromJson(sizeListString, type)
    }
}