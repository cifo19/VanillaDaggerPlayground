package com.presentation.daggerplayground.di

import android.content.Context
import com.presentation.daggerplayground.DaggerPlaygroundApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(private val application: DaggerPlaygroundApplication) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return application.applicationContext
    }
}