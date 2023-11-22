package com.example.myapplication.presentation.ui.fragments.sign_in_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.responcemodel.ResponseLogin
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.domen.usecase.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginLiveData = MutableLiveData<ResponseStates<ResponseLogin>>()
    val loginLiveData: LiveData<ResponseStates<ResponseLogin>> = _loginLiveData

    fun login(login: String, password: String) {
        viewModelScope.launch {
            _loginLiveData.value = ResponseStates.Loading()

            try {
                _loginLiveData.value = ResponseStates.Success(
                    loginUseCase.execute(login, password)
                )
            }
            catch (e: Exception) {
                _loginLiveData.value = ResponseStates.Failure(e)
            }
        }
    }
}