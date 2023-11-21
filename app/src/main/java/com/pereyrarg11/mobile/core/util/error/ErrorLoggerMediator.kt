package com.pereyrarg11.mobile.core.util.error

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorLoggerMediator @Inject constructor(
    private val errorLoggers: Set<@JvmSuppressWildcards ErrorLogger>,
) : ErrorLogger {
    override fun logErrorMessage(errorMessage: String) {
        errorLoggers.forEach { logger ->
            logger.logErrorMessage(errorMessage)
        }
    }

    override fun logException(exception: Exception) {
        errorLoggers.forEach { logger ->
            logger.logException(exception)
        }
    }

    override fun setProperties(properties: Map<String, String>) {
        errorLoggers.forEach { logger ->
            logger.setProperties(properties)
        }
    }
}
