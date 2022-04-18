package com.presentation.daggerplayground.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.presentation.daggerplayground.DaggerPlaygroundApplication
import com.presentation.daggerplayground.R
import com.presentation.daggerplayground.home.hobbies.HobbiesFragment
import com.presentation.daggerplayground.home.information.InformationFragment
import com.presentation.daggerplayground.login.LoginActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DaggerPlaygroundApplication)
            .applicationComponent
            .injectHomeActivity(this)
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.logout).setOnClickListener {
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val arguments = intent.getParcelableExtra<HomeActivityArgument>(KEY_HOME_ARGUMENTS)!!
        homeViewModel.setUserInfo(arguments)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.informationContainer, InformationFragment())
                .add(R.id.hobbiesContainer, HobbiesFragment())
                .commit()
        }
    }

    companion object {
        const val KEY_HOME_ARGUMENTS = "homeArguments"
    }
}