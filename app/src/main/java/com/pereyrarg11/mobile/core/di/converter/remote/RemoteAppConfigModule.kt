package com.pereyrarg11.mobile.core.di.converter.remote

import com.pereyrarg11.mobile.core.data.remote.converter.RemoteAppConfigConverter
import com.pereyrarg11.mobile.core.data.remote.dto.AppConfigDto
import com.pereyrarg11.mobile.core.data.util.Converter
import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteAppConfigModule {
    @Binds
    @Singleton
    abstract fun bindRemoteAppConfigConverter(
        converter: RemoteAppConfigConverter,
    ): Converter<AppConfigDto, AppConfigModel>
}
