package com.pereyrarg11.mobile.core.presentation.model

import com.pereyrarg11.mobile.core.presentation.util.UiText

/**
 * Contains the basic attributes which describe the state of a Screen.
 */
interface UiState {
    val isLoading: Boolean
    val hasError: Boolean
    val errorMessage: UiText
}
