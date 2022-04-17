package com.presentation.daggerplayground.di

import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
}
