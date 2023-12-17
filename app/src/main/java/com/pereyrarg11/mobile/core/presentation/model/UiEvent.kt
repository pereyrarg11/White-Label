package com.pereyrarg11.mobile.core.presentation.model

import com.pereyrarg11.mobile.core.presentation.util.UiText

sealed class UiEvent {
    data class ShowLoading(val isLoading: Boolean) : UiEvent()

    data class ShowMessage(val message: UiText) : UiEvent()

    data class ShowError(val message: UiText) : UiEvent()

    object Success : UiEvent()
}
