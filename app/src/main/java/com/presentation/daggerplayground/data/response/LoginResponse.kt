package com.presentation.daggerplayground.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("information") val information: InformationResponse,
    @SerializedName("hobbies") val hobbies: List<String>
)

data class InformationResponse(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String
)
