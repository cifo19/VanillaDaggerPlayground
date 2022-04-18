package com.presentation.daggerplayground.di

import com.presentation.daggerplayground.DaggerPlaygroundApplication
import com.presentation.daggerplayground.home.HomeActivity
import com.presentation.daggerplayground.home.hobbies.HobbiesFragment
import com.presentation.daggerplayground.home.information.InformationFragment
import com.presentation.daggerplayground.login.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        PicassoModule::class,
        UserServiceModule::class,
        ApplicationContextModule::class,
    ]
)
interface ApplicationComponent {

    // Application
    fun injectApplication(daggerPlaygroundApplication: DaggerPlaygroundApplication)

    // Activity
    fun injectLoginActivity(loginActivity: LoginActivity)
    fun injectHomeActivity(homeActivity: HomeActivity)

    // Fragment
    fun injectInformationFragment(informationFragment: InformationFragment)
    fun injectHobbiesFragment(hobbiesFragment: HobbiesFragment)
}
