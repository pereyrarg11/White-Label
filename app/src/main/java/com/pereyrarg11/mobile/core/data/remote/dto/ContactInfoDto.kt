package com.pereyrarg11.mobile.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ContactInfoDto(
    @SerializedName("fullName") val fullName: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("linkedinUrl") val linkedinUrl: String?,
    @SerializedName("githubUrl") val githubUrl: String?,
)
