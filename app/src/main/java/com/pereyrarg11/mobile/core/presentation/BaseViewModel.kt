package com.pereyrarg11.mobile.core.presentation

import androidx.lifecycle.ViewModel
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.presentation.util.UiText

abstract class BaseViewModel constructor(
    private val errorLogger: ErrorLogger,
) : ViewModel() {

    protected abstract fun handleError(exception: Exception?)

    protected fun getErrorMessage(exception: Exception?): UiText {
        // TODO: return an error message for the most common exceptions here
        return UiText.StringResource(R.string.error_default)
    }

    fun logException(exception: Exception) {
        errorLogger.logException(exception)
    }
}
