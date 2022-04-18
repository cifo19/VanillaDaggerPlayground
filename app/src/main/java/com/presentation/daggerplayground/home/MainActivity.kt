package com.presentation.daggerplayground.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.presentation.daggerplayground.DaggerPlaygroundApplication
import com.presentation.daggerplayground.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DaggerPlaygroundApplication)
            .applicationComponent
            .injectMainActivity(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("picassoAct", picasso.toString())
    }
}
