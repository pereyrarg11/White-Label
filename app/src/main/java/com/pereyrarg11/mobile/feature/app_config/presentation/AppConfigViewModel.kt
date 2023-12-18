package com.pereyrarg11.mobile.feature.app_config.presentation

import com.pereyrarg11.mobile.core.domain.repository.AppConfigRepository
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppConfigViewModel @Inject constructor(
    errorLogger: ErrorLogger,
    appConfigRepository: AppConfigRepository,
) : BaseViewModel(errorLogger) {

    val appConfig = appConfigRepository.getConfig()

    override fun handleError(exception: Exception?) {
        if (exception != null) logException(exception)
    }
}
