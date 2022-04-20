package com.presentation.daggerplayground.home.information

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.presentation.daggerplayground.R
import com.presentation.daggerplayground.home.HomeActivity
import com.presentation.daggerplayground.home.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class InformationFragment : Fragment(R.layout.fragment_information) {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as HomeActivity)
            .loginUserComponent
            .injectInformationFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.name).text = homeViewModel.getNameSurname()
        view.findViewById<Button>(R.id.verify).setOnClickListener {
            homeViewModel.setVerified()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.verified.collect { verified ->
                    val verifiedText = if (verified) "verified" else "not verified"
                    view.findViewById<TextView>(R.id.verified).text = verifiedText
                }
            }
        }
    }
}
