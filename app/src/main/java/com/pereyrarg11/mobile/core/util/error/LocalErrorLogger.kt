package com.pereyrarg11.mobile.core.util.error

import android.util.Log

class LocalErrorLogger : ErrorLogger {
    private val logTag = "LocalErrorLogger"

    override fun logErrorMessage(errorMessage: String) {
        Log.e(logTag, errorMessage)
    }

    override fun logException(exception: Exception) {
        Log.w(logTag, "Exception handled", exception)
    }

    override fun setProperties(properties: Map<String, String>) {
        val propertiesAsString = properties.entries.joinToString(", ") { entry ->
            "${entry.key}:${entry.value}"
        }

        Log.d(logTag, propertiesAsString)
    }
}
