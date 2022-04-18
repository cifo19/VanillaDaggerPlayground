package com.presentation.daggerplayground.data

import com.presentation.daggerplayground.data.request.LoginRequest
import com.presentation.daggerplayground.data.response.LoginResponse
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService
) {

    suspend fun login(name: String, password: String): LoginResponse {
        val request = LoginRequest(name, password)
        return userService.login(request)
    }
}
