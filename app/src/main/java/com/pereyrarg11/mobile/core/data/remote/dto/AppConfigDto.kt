package com.pereyrarg11.mobile.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AppConfigDto(
    @SerializedName(AppConfigKeys.CONTACT_INFO) val contactInfo: String?,
    @SerializedName(AppConfigKeys.DEVELOPER_NICKNAME) val developerNickname: String?,
    @SerializedName(AppConfigKeys.SHOW_CONTACT_INFO) val showContactInfo: Boolean?,
    @SerializedName(AppConfigKeys.STARS) val stars: Int?,
)
