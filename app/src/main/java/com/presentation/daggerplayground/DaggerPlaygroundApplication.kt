package com.presentation.daggerplayground

import android.app.Application
import com.presentation.daggerplayground.di.ApplicationComponent
import com.presentation.daggerplayground.di.DaggerApplicationComponent

class DaggerPlaygroundApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}
