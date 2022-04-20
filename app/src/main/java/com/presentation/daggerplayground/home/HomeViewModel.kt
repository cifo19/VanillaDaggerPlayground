package com.presentation.daggerplayground.home

import com.presentation.daggerplayground.di.ActivityScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@ActivityScope
class HomeViewModel @Inject constructor() {

    private var userInfo: UserInfo? = null

    private var verifiedStateFlow = MutableStateFlow(false)
    val verified = verifiedStateFlow.asStateFlow()

    fun setUserInfo(homeActivityArgument: HomeActivityArgument) {
        userInfo = UserInfo(homeActivityArgument)
    }

    fun setVerified() {
        verifiedStateFlow.value = true
    }

    fun getNameSurname(): String = with(userInfo?.homeActivityArgument) {
        this?.name.orEmpty() + this?.surname.orEmpty()
    }

    fun getHobbies(): List<String> {
        return userInfo?.homeActivityArgument?.hobbies.orEmpty()
    }
}

data class UserInfo(val homeActivityArgument: HomeActivityArgument)