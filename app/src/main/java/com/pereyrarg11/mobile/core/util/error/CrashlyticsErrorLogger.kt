package com.pereyrarg11.mobile.core.util.error

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.setCustomKeys
import com.google.firebase.ktx.Firebase

class CrashlyticsErrorLogger : ErrorLogger {
    override fun logErrorMessage(errorMessage: String) {
        logException(Exception(errorMessage))
    }

    override fun logException(exception: Exception) {
        Firebase.crashlytics.recordException(exception)
    }

    override fun setProperties(properties: Map<String, String>) {
        Firebase.crashlytics.setCustomKeys {
            properties.entries.forEach { entry ->
                key(entry.key, entry.value)
            }
        }
    }
}
