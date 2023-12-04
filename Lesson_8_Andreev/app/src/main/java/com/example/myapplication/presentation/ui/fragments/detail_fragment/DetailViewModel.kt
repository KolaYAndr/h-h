package com.example.myapplication.presentation.ui.fragments.detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.product.Product
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.domain.usecase.ProductUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val productUseCase: ProductUseCase) : ViewModel() {
    private val _productLiveData = MutableLiveData<ResponseStates<Product>>()
    val productLiveData: LiveData<ResponseStates<Product>> = _productLiveData

    fun getProduct(id: String) {
        viewModelScope.launch {
            _productLiveData.value = ResponseStates.Loading()

            try {
                _productLiveData.value = ResponseStates.Success(
                    productUseCase.getProduct(id)
                )
            }
            catch (e: Exception){
                _productLiveData.value = ResponseStates.Failure(e)
            }
        }
    }
}