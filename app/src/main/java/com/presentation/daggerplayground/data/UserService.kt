package com.presentation.daggerplayground.data

import com.presentation.daggerplayground.data.request.LoginRequest
import com.presentation.daggerplayground.data.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("Login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}
