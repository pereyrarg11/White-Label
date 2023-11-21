package com.pereyrarg11.mobile.core.di

import com.pereyrarg11.mobile.core.util.error.CrashlyticsErrorLogger
import com.pereyrarg11.mobile.core.util.error.ErrorLogger
import com.pereyrarg11.mobile.core.util.error.LocalErrorLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

/**
 * Bind a set of implementations for the same interface.
 * Facade allows to have different implementations of the same interface.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class FacadeModule {
    /* ErrorLogger */
    @Binds
    @IntoSet
    abstract fun bindCrashlyticsErrorLogger(logger: CrashlyticsErrorLogger): ErrorLogger

    @Binds
    @IntoSet
    abstract fun bindLocalErrorLogger(logger: LocalErrorLogger): ErrorLogger
}
