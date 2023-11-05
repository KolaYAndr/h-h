package com.example.lesson_4.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Lesson4ViewModel : ViewModel() {
    private val _stringValue: MutableLiveData<String> = MutableLiveData()
    val stringValue: LiveData<String> = _stringValue

    fun changeStringValue(newStringValue: String){
        _stringValue.value = newStringValue
    }
}