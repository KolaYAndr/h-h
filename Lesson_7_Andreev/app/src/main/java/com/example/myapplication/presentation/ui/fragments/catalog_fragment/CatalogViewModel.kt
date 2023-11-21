package com.example.myapplication.presentation.ui.fragments.catalog_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.data.product.Product
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.domen.usecase.ProductUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatalogViewModel @Inject constructor(private val productUseCase: ProductUseCase) : ViewModel() {
    private val _productLiveData = MutableLiveData<ResponseStates<List<Product>>>()
    val productData: MutableLiveData<ResponseStates<List<Product>>> = _productLiveData

    fun getProducts(){
        viewModelScope.launch {
            _productLiveData.value = ResponseStates.Loading()

            try {
                _productLiveData.value = ResponseStates.Success(
                    productUseCase.getProducts(USUAL_REQUEST_PRODUCT_SIZE)
                )
            }
            catch (e: Exception){
                _productLiveData.value = ResponseStates.Failure(e)
            }
        }
    }

    companion object {
        val USUAL_REQUEST_PRODUCT_SIZE = R.integer.default_request_product_size
    }
}