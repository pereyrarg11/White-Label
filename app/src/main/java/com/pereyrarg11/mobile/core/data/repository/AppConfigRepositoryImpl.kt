package com.pereyrarg11.mobile.core.data.repository

import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.pereyrarg11.mobile.core.data.remote.dto.AppConfigDto
import com.pereyrarg11.mobile.core.data.remote.dto.AppConfigKeys
import com.pereyrarg11.mobile.core.data.util.Converter
import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import com.pereyrarg11.mobile.core.domain.repository.AppConfigRepository
import com.pereyrarg11.mobile.core.domain.util.Result
import com.pereyrarg11.mobile.core.logger.debug.DebugLogger
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppConfigRepositoryImpl @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
    private val converter: Converter<AppConfigDto, AppConfigModel>,
    private val provider: AppConfigProvider,
    private val debugLogger: DebugLogger,
    private val errorLogger: ErrorLogger,
) : AppConfigRepository {

    private val logTag = "AppConfigRepository"

    override suspend fun loadConfig(): Flow<Result<Unit>> = callbackFlow {
        trySendBlocking(Result.Loading(isLoading = true))

        firebaseRemoteConfig
            .fetchAndActivate()
            .addOnCompleteListener { task ->
                debugLogger.logMessage(
                    logTag,
                    "config was fetched and activated: ${task.isSuccessful}"
                )

                if (task.isSuccessful) {
                    provider.inMemoryAppConfig = converter.convert(getAppConfigFromFirebase())

                    trySendBlocking(Result.Success(Unit))
                } else {
                    trySendBlocking(Result.Error(exception = task.exception))
                }
                channel.close()
            }

        awaitClose {
            // TODO: are we sure there is nothing to do here?
        }
    }

    override fun getConfig(): AppConfigModel = provider.inMemoryAppConfig

    override suspend fun listenToRealTimeUpdates(entryName: String?): Flow<Result<Unit>> =
        callbackFlow {
            firebaseRemoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
                override fun onUpdate(configUpdate: ConfigUpdate) {
                    debugLogger.logMessage(logTag, "updated keys: ${configUpdate.updatedKeys}")

                    if (entryName == null || configUpdate.updatedKeys.contains(entryName)) {
                        firebaseRemoteConfig.activate().addOnCompleteListener { task ->
                            debugLogger.logMessage(
                                logTag,
                                "fetched config was activated: ${task.isSuccessful}"
                            )

                            if (task.isSuccessful) {
                                provider.inMemoryAppConfig =
                                    converter.convert(getAppConfigFromFirebase())
                                trySendBlocking(Result.Success(Unit))
                            } else {
                                trySendBlocking(Result.Error(exception = task.exception))
                            }
                        }
                    }
                }

                override fun onError(error: FirebaseRemoteConfigException) {
                    errorLogger.logException(error)
                }
            })

            awaitClose {
                // TODO: are we sure there is nothing to do here?
            }
        }

    private fun getAppConfigFromFirebase(): AppConfigDto {
        return AppConfigDto(
            contactInfo = firebaseRemoteConfig.getString(AppConfigKeys.CONTACT_INFO),
            developerNickname = firebaseRemoteConfig.getString(AppConfigKeys.DEVELOPER_NICKNAME),
            showContactInfo = firebaseRemoteConfig.getBoolean(AppConfigKeys.SHOW_CONTACT_INFO),
            stars = firebaseRemoteConfig.getDouble(AppConfigKeys.STARS).toInt(),
        )
    }
}
