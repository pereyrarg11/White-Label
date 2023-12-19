package com.pereyrarg11.mobile.core.data.repository

import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppConfigProvider @Inject constructor() {
    var inMemoryAppConfig = AppConfigModel()
}
