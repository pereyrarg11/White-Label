package com.pereyrarg11.mobile.feature.splash.presentation.model

import com.pereyrarg11.mobile.core.presentation.util.UiText

sealed class SplashUiEvent {
    data class ShowError(val message: UiText) : SplashUiEvent()

    object ConfigurationLoaded : SplashUiEvent()
}
