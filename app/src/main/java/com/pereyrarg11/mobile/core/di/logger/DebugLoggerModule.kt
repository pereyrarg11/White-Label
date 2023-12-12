package com.pereyrarg11.mobile.core.di.logger

import com.pereyrarg11.mobile.core.logger.debug.CrashlyticsDebugLogger
import com.pereyrarg11.mobile.core.logger.debug.DebugLogger
import com.pereyrarg11.mobile.core.logger.debug.DebugLoggerMediator
import com.pereyrarg11.mobile.core.logger.debug.LogcatDebugLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class DebugLoggerModule {
    @Binds
    @IntoSet
    abstract fun bindLogcatDebugLogger(
        debugLogger: LogcatDebugLogger
    ): DebugLogger.Facade

    @Binds
    @IntoSet
    abstract fun bindCrashlyticsDebugLogger(
        debugLogger: CrashlyticsDebugLogger
    ): DebugLogger.Facade

    @Binds
    abstract fun bindDebugLoggerMediator(
        debugLogger: DebugLoggerMediator
    ): DebugLogger
}
