package com.pereyrarg11.mobile.core.logger.debug

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LogcatDebugLogger @Inject constructor() : DebugLogger.Facade {
    override fun logMessage(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun logMessage(tag: String, messageTemplate: () -> String) {
        logMessage(tag, messageTemplate())
    }
}
