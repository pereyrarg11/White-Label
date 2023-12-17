package com.pereyrarg11.mobile.core.data.remote.converter

import com.google.gson.Gson
import com.pereyrarg11.mobile.core.data.remote.dto.AppConfigDto
import com.pereyrarg11.mobile.core.data.util.Converter
import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import com.pereyrarg11.mobile.core.domain.model.ContactInfoModel
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteAppConfigConverter @Inject constructor(
    private val errorLogger: ErrorLogger,
) : Converter<AppConfigDto, AppConfigModel> {
    override fun convert(input: AppConfigDto): AppConfigModel {
        return AppConfigModel(
            contactInfo = convertContactInfo(input.contactInfo),
            developerNickname = input.developerNickname.orEmpty(),
            showContactInfo = input.showContactInfo ?: false,
            stars = input.stars ?: 0
        )
    }

    // TODO: turn this function into a Converter
    private fun convertContactInfo(json: String?): ContactInfoModel {
        if (json.isNullOrBlank().not()) {
            try {
                return Gson().fromJson(json, ContactInfoModel::class.java)
            } catch (exception: Exception) {
                errorLogger.logException(exception)
            }
        }

        return ContactInfoModel()
    }
}
