package com.pereyrarg11.mobile.feature.appConfig.presentation.model

import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import com.pereyrarg11.mobile.core.presentation.model.UiState
import com.pereyrarg11.mobile.core.presentation.util.UiText

data class AppConfigUiState(
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
    override val errorMessage: UiText = UiText.PlainText(""),
    val appConfig: AppConfigModel,
) : UiState
