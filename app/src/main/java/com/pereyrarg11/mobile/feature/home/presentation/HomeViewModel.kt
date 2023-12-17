package com.pereyrarg11.mobile.feature.home.presentation

import com.pereyrarg11.mobile.core.domain.repository.AppConfigRepository
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    errorLogger: ErrorLogger,
    appConfigRepository: AppConfigRepository,
) : BaseViewModel(errorLogger) {

    val developerName: String = appConfigRepository.getConfig().developerNickname

    override fun handleError(exception: Exception?) {
    }
}
