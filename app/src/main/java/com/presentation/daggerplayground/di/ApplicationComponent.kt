package com.presentation.daggerplayground.di

import com.presentation.daggerplayground.DaggerPlaygroundApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, PicassoModule::class, ApplicationContextModule::class])
interface ApplicationComponent {

    fun injectApplication(daggerPlaygroundApplication: DaggerPlaygroundApplication)
}
