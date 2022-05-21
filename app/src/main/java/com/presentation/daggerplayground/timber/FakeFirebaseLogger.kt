package com.presentation.daggerplayground.timber

import android.annotation.SuppressLint
import android.util.Log
import javax.inject.Inject

class FakeFirebaseLogger @Inject constructor() {

    @SuppressLint("LogNotTimber")
    fun log(message: String) {
        Log.d("Firebase ", message)
    }
}
