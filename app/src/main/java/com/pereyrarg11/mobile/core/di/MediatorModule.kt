package com.pereyrarg11.mobile.core.di

import com.pereyrarg11.mobile.core.util.error.ErrorLogger
import com.pereyrarg11.mobile.core.util.error.ErrorLoggerMediator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Qualifier
annotation class Mediator

/**
 * Binds the "main" implementation of an interface.
 * Such implementation must call the method for each entry into a implementation Set.
 * Mediator brings the ability to execute the same method in all the different implementations.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MediatorModule {
    @Mediator
    @Binds
    abstract fun bindErrorLoggerMediator(mediator: ErrorLoggerMediator): ErrorLogger
}
