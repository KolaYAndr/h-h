package com.example.myapplication.db.converters

import androidx.room.TypeConverter
import com.example.myapplication.data.product.Badge
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class BadgesConverter {
    @TypeConverter
    fun fromBadgeList(badgeList: List<Badge>): String {
        val gson = Gson()
        return gson.toJson(badgeList)
    }

    @TypeConverter
    fun toBadgeList(badgeListString: String): List<Badge> {
        val gson = Gson()
        val type = object : TypeToken<List<Badge>>() {}.type
        return gson.fromJson(badgeListString, type)
    }
}

