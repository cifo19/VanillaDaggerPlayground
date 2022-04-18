package com.presentation.daggerplayground.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.presentation.daggerplayground.DaggerPlaygroundApplication
import com.presentation.daggerplayground.R
import com.presentation.daggerplayground.home.HomeActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var loginActivityViewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DaggerPlaygroundApplication)
            .applicationComponent
            .injectLoginActivity(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.login).setOnClickListener {
            loginActivityViewModel.login("name", "surname")
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginActivityViewModel.homeActivityArgument.collect {
                    finish()
                    startActivity(
                        Intent(this@LoginActivity, HomeActivity::class.java)
                            .apply { putExtra(HomeActivity.KEY_HOME_ARGUMENTS, it) }
                    )
                }
            }
        }
    }
}
