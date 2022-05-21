package com.presentation.daggerplayground.initializers

import android.content.Context
import androidx.startup.Initializer
import com.presentation.daggerplayground.BuildConfig
import com.presentation.daggerplayground.DaggerPlaygroundApplication
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        val tree = if (BuildConfig.DEBUG) {
            Timber.DebugTree()
        } else {
            (context.applicationContext as DaggerPlaygroundApplication)
                .applicationComponent
                .timberReleaseTree()
        }
        Timber.plant(tree)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}
