package com.presentation.daggerplayground.login

import com.presentation.daggerplayground.data.UserRepository
import com.presentation.daggerplayground.data.response.LoginResponse
import com.presentation.daggerplayground.home.HomeActivityArgument
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(
    private val userRepository: UserRepository
) {

    private val homeActivityArgumentChannel: Channel<HomeActivityArgument> = Channel(BUFFERED)
    val homeActivityArgument = homeActivityArgumentChannel.receiveAsFlow()

    fun login(name: String, password: String) = MainScope().launch {
        runCatching { userRepository.login(name, password) }
            .onFailure { it.printStackTrace() }
            .onSuccess { onLoginSucceeded(it) }
    }

    private fun onLoginSucceeded(loginResponse: LoginResponse) = with(loginResponse) {
        val homeActivityArgument = HomeActivityArgument(
            information.name,
            information.surname,
            hobbies
        )
        homeActivityArgumentChannel.trySend(homeActivityArgument)
    }
}
