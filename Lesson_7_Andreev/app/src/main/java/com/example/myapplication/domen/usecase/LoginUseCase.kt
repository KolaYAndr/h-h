package com.example.myapplication.domen.usecase

import com.example.myapplication.data.repository.AccessRepository
import com.example.myapplication.data.repository.PreferenceStorage
import com.example.myapplication.data.responcemodel.ResponseLogin
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AccessRepository,
    private val preferenceStorage: PreferenceStorage,
) {
    suspend fun execute(email: String, password: String): ResponseLogin {
        val loginData = repository.login(email, password)
        preferenceStorage.userToken = loginData.accessToken
        return loginData
    }
}