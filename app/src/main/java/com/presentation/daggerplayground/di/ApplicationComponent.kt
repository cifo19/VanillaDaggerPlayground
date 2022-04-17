package com.presentation.daggerplayground.di

import com.presentation.daggerplayground.DaggerPlaygroundApplication
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun injectApplication(daggerPlaygroundApplication: DaggerPlaygroundApplication)
}
