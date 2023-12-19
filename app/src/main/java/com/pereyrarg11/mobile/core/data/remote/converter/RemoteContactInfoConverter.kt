package com.pereyrarg11.mobile.core.data.remote.converter

import com.google.gson.Gson
import com.pereyrarg11.mobile.core.data.remote.dto.ContactInfoDto
import com.pereyrarg11.mobile.core.data.util.Converter
import com.pereyrarg11.mobile.core.domain.model.ContactInfoModel
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteContactInfoConverter @Inject constructor(
    private val errorLogger: ErrorLogger,
) : Converter<String?, ContactInfoModel> {

    override fun convert(input: String?): ContactInfoModel {
        if (input.isNullOrBlank().not()) {
            try {
                val contactInfoDto = Gson().fromJson(input, ContactInfoDto::class.java)

                return ContactInfoModel(
                    fullName = contactInfoDto.fullName.orEmpty(),
                    email = contactInfoDto.email.orEmpty(),
                    linkedinUrl = contactInfoDto.linkedinUrl.orEmpty(),
                    githubUrl = contactInfoDto.githubUrl.orEmpty(),
                )
            } catch (exception: Exception) {
                errorLogger.logException(exception)
            }
        }

        return ContactInfoModel()
    }
}
