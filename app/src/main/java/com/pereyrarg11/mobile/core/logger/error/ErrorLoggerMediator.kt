package com.pereyrarg11.mobile.core.logger.error

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorLoggerMediator @Inject constructor(
    private val facades: Set<@JvmSuppressWildcards ErrorLogger.Facade>,
) : ErrorLogger {

    override fun logException(exception: Exception) {
        facades.forEach { logger ->
            logger.logException(exception)
        }
    }

    override fun setProperties(properties: Map<String, String>) {
        facades.forEach { logger ->
            logger.setProperties(properties)
        }
    }
}
