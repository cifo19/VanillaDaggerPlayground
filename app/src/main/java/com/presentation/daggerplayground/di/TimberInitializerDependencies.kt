package com.presentation.daggerplayground.di

import com.presentation.daggerplayground.timber.TimberReleaseTree

interface TimberInitializerDependencies {
    fun timberReleaseTree(): TimberReleaseTree
}
