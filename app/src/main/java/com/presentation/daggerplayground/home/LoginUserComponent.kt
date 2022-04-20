package com.presentation.daggerplayground.home

import com.presentation.daggerplayground.di.ActivityScope
import com.presentation.daggerplayground.home.hobbies.HobbiesFragment
import com.presentation.daggerplayground.home.information.InformationFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginUserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginUserComponent
    }

    fun inject(homeActivity: HomeActivity)

    // Fragment
    fun injectInformationFragment(informationFragment: InformationFragment)
    fun injectHobbiesFragment(hobbiesFragment: HobbiesFragment)
}