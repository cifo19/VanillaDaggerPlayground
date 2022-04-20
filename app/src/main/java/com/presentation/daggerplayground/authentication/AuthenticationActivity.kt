package com.presentation.daggerplayground.authentication

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

class AuthenticationActivity : AppCompatActivity() {

    @Inject
    lateinit var authenticationActivityViewModel: AuthenticationActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DaggerPlaygroundApplication)
            .applicationComponent
            .injectAuthenticationActivity(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        findViewById<Button>(R.id.login).setOnClickListener {
            authenticationActivityViewModel.login("name", "surname")
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                authenticationActivityViewModel.homeActivityArgument.collect {
                    finish()
                    startActivity(
                        Intent(this@AuthenticationActivity, HomeActivity::class.java)
                            .apply { putExtra(HomeActivity.KEY_HOME_ARGUMENTS, it) }
                    )
                }
            }
        }
    }
}
