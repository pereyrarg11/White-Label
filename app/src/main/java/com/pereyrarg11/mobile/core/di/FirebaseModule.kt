package com.pereyrarg11.mobile.core.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.pereyrarg11.mobile.BuildConfig
import com.pereyrarg11.mobile.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirebaseCrashlytics(): FirebaseCrashlytics = Firebase.crashlytics

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(): FirebaseAnalytics = Firebase.analytics

    @Provides
    @Singleton
    fun provideFirebaseRemoteConfig(): FirebaseRemoteConfig {
        val settings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = if (BuildConfig.DEBUG) {
                TimeUnit.MINUTES.toSeconds(1L)
            } else {
                TimeUnit.HOURS.toSeconds(1L)
            }
        }

        return Firebase.remoteConfig.apply {
            setDefaultsAsync(R.xml.remote_config_defaults)
            setConfigSettingsAsync(settings)
        }
    }
}
