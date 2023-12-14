package com.example.myapplication.presentation.ui.fragments.order_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.product.OrderProduct
import com.example.myapplication.data.responcemodel.ResponseOrder
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.domain.usecase.OrderUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class OrderViewModel @Inject constructor(private val orderUseCase: OrderUseCase) : ViewModel(){
    private val _orderLiveData = MutableLiveData<ResponseStates<ResponseOrder>>()
    val orderLiveData: LiveData<ResponseStates<ResponseOrder>> = _orderLiveData

    fun order(house: String, apartment: String, date: String, products: List<OrderProduct>) {
        viewModelScope.launch {
            _orderLiveData.value = ResponseStates.Loading()

            try {
                _orderLiveData.value = ResponseStates.Success(
                    orderUseCase.order(house, apartment, date, products)
                )
            }
            catch (e: Exception){
                _orderLiveData.value = ResponseStates.Failure(e)
            }
        }
    }
}