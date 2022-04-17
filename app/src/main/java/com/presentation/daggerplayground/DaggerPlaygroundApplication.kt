package com.presentation.daggerplayground

import android.app.Application
import android.util.Log
import com.google.gson.Gson
import com.presentation.daggerplayground.di.ApplicationComponent
import com.presentation.daggerplayground.di.DaggerApplicationComponent
import javax.inject.Inject

class DaggerPlaygroundApplication : Application() {

    @Inject
    lateinit var gson: Gson

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
        applicationComponent.injectApplication(daggerPlaygroundApplication = this)

        Log.d("gson", gson.toString())
    }
}
