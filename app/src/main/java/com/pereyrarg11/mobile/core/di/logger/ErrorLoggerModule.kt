package com.pereyrarg11.mobile.core.di.logger

import com.pereyrarg11.mobile.core.logger.error.CrashlyticsErrorLogger
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.logger.error.ErrorLoggerMediator
import com.pereyrarg11.mobile.core.logger.error.LocalErrorLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorLoggerModule {
    @Binds
    @IntoSet
    abstract fun bindCrashlyticsErrorLogger(
        errorLogger: CrashlyticsErrorLogger
    ): ErrorLogger.Facade

    @Binds
    @IntoSet
    abstract fun bindLocalErrorLogger(
        errorLogger: LocalErrorLogger
    ): ErrorLogger.Facade

    @Binds
    abstract fun bindErrorLoggerMediator(
        errorLogger: ErrorLoggerMediator
    ): ErrorLogger
}
