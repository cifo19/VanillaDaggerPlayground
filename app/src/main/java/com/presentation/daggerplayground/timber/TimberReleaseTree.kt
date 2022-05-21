package com.presentation.daggerplayground.timber

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimberReleaseTree @Inject constructor() : Timber.Tree() {

    @Inject
    lateinit var firebaseLogger: FakeFirebaseLogger

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        firebaseLogger.log(message)
    }
}
