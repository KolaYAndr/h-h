package com.example.myapplication.data.interceptor

import com.example.myapplication.data.repository.PreferenceStorage
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Singleton

@Singleton
class HeaderInterceptor(private val preferenceStorage: PreferenceStorage) : Interceptor {
    private val token: String by lazy { preferenceStorage.userToken }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = if (!original.url.encodedPath.contains("user/signin") || token.isBlank()) {
            original.newBuilder().header(HEADER_AUTHORIZATION, "$TOKEN_TYPE $token")
        } else {
            original.newBuilder()
        }
            .method(original.method, original.body)
            .build()

        return chain.proceed(request)
    }

    companion object {
        const val HEADER_AUTHORIZATION = "Authorization"
        const val TOKEN_TYPE = "Bearer "
    }
}