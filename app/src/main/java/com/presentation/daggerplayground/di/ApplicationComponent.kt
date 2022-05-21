package com.presentation.daggerplayground.di

import com.presentation.daggerplayground.DaggerPlaygroundApplication
import com.presentation.daggerplayground.authentication.AuthenticationActivity
import com.presentation.daggerplayground.home.LoginUserComponent
import com.presentation.daggerplayground.timber.TimberReleaseTree
import dagger.Component
import timber.log.Timber
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        PicassoModule::class,
        UserServiceModule::class,
        ApplicationContextModule::class,
        SubcomponentsModule::class
    ]
)
interface ApplicationComponent : TimberInitializerDependencies {

    fun injectApplication(daggerPlaygroundApplication: DaggerPlaygroundApplication)

    fun loginUserComponent(): LoginUserComponent.Factory

    fun injectAuthenticationActivity(authenticationActivity: AuthenticationActivity)
}
