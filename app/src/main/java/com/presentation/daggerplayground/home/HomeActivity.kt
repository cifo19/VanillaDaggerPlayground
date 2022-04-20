package com.presentation.daggerplayground.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.presentation.daggerplayground.DaggerPlaygroundApplication
import com.presentation.daggerplayground.R
import com.presentation.daggerplayground.authentication.AuthenticationActivity
import com.presentation.daggerplayground.home.hobbies.HobbiesFragment
import com.presentation.daggerplayground.home.information.InformationFragment
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    lateinit var loginUserComponent: LoginUserComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        loginUserComponent = (application as DaggerPlaygroundApplication)
            .applicationComponent
            .loginUserComponent()
            .create()
            .also { it.inject(this) }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.logout).setOnClickListener {
            finish()
            startActivity(Intent(this, AuthenticationActivity::class.java))
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