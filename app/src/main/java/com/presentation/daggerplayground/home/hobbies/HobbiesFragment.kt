package com.presentation.daggerplayground.home.hobbies

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.presentation.daggerplayground.R
import com.presentation.daggerplayground.home.HomeActivity
import com.presentation.daggerplayground.home.HomeViewModel
import javax.inject.Inject

class HobbiesFragment: Fragment(R.layout.fragment_hobbies) {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as HomeActivity)
            .loginUserComponent
            .injectHobbiesFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.hobbies).text = homeViewModel.getHobbies().joinToString()
    }
}
