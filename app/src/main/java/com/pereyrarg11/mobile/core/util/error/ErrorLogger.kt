package com.pereyrarg11.mobile.core.util.error

// TODO: use a mediator when DI is implemented
interface ErrorLogger {
    fun logErrorMessage(errorMessage: String)

    fun logException(exception: Exception)

    fun setProperties(properties: Map<String, String>)
}
