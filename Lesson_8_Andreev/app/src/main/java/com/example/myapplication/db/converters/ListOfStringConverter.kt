package com.example.myapplication.db.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class ListOfStringConverter {
    @TypeConverter
    fun fromDetailsList(detailsList: List<String>): String {
        val gson = Gson()
        return gson.toJson(detailsList)
    }

    @TypeConverter
    fun toDetailsList(detailsListString: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(detailsListString, type)
    }
}