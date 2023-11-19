package com.example.myapplication.data.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceStorage @Inject constructor(
    context: Context,
) {
    private val pref: SharedPreferences
    var userToken: String
        get() = pref.getString(PREF_USER_TOKEN, "") ?: ""
        set(value) = pref.edit { putString(PREF_USER_TOKEN, value) }

    init {
        pref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        const val PREF_FILE_NAME = "pref_file"

        private const val PREF_USER_TOKEN = "pref_user_token"
    }
}