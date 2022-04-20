package com.presentation.daggerplayground.di

import com.presentation.daggerplayground.home.LoginUserComponent
import dagger.Module

@Module(subcomponents = [LoginUserComponent::class])
object SubcomponentsModule
