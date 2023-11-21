package com.pereyrarg11.mobile.core.util.error

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalErrorLogger @Inject constructor() : ErrorLogger {
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
