package com.presentation.daggerplayground

import android.app.Application
import androidx.startup.AppInitializer
import com.presentation.daggerplayground.di.ApplicationComponent
import com.presentation.daggerplayground.di.ApplicationContextModule
import com.presentation.daggerplayground.di.DaggerApplicationComponent
import com.presentation.daggerplayground.initializers.TimberInitializer

class DaggerPlaygroundApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
        applicationComponent.injectApplication(daggerPlaygroundApplication = this)

        AppInitializer.getInstance(this)
            .initializeComponent(TimberInitializer::class.java)
    }
}
