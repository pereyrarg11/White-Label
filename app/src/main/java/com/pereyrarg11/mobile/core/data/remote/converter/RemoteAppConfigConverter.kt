package com.pereyrarg11.mobile.core.data.remote.converter

import com.pereyrarg11.mobile.core.data.remote.dto.AppConfigDto
import com.pereyrarg11.mobile.core.data.util.Converter
import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import com.pereyrarg11.mobile.core.domain.model.ContactInfoModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteAppConfigConverter @Inject constructor(
    private val contactInfoConverter: Converter<String?, ContactInfoModel>,
) : Converter<AppConfigDto, AppConfigModel> {

    override fun convert(input: AppConfigDto): AppConfigModel {
        return AppConfigModel(
            contactInfo = contactInfoConverter.convert(input.contactInfo),
            contactInfoJson = input.contactInfo.orEmpty(),
            developerNickname = input.developerNickname.orEmpty(),
            showContactInfo = input.showContactInfo ?: false,
            stars = input.stars ?: 0,
        )
    }
}
