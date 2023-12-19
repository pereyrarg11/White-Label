package com.pereyrarg11.mobile.core.domain.model

data class AppConfigModel(
    val contactInfo: ContactInfoModel = ContactInfoModel(),
    val contactInfoJson: String = "",
    val developerNickname: String = "",
    val showContactInfo: Boolean = false,
    val stars: Int = 0,
)
