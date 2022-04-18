package com.presentation.daggerplayground.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeActivityArgument(
    val name: String,
    val surname: String,
    val hobbies: List<String>,
) : Parcelable
