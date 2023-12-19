package com.pereyrarg11.mobile.core.di

import com.pereyrarg11.mobile.core.data.repository.AppConfigRepositoryImpl
import com.pereyrarg11.mobile.core.domain.repository.AppConfigRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindAppConfigRepository(
        repository: AppConfigRepositoryImpl
    ): AppConfigRepository
}
