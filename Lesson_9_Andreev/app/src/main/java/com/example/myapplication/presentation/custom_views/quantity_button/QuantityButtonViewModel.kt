package com.example.myapplication.presentation.custom_views.quantity_button

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuantityButtonViewModel : ViewModel() {
    private val _productCounterLiveData = MutableLiveData<Int>()
    val productCounterLiveData: MutableLiveData<Int> = _productCounterLiveData

    init {
        _productCounterLiveData.value = 1
    }

    fun increaseCounter() {
        _productCounterLiveData.let {
            it.value = it.value!! + 1
        }
    }

    fun decreaseCounter() {
        _productCounterLiveData.let {
            val result = it.value!! - 1
            if (result <= 1) {
                it.value = 1
            } else it.value = result
        }
    }
}