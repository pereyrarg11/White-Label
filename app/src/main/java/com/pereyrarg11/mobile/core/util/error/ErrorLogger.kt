package com.pereyrarg11.mobile.core.util.error

interface ErrorLogger {
    fun logErrorMessage(errorMessage: String)

    fun logException(exception: Exception)

    fun setProperties(properties: Map<String, String>)
}
