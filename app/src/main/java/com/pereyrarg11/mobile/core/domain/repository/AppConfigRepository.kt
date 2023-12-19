package com.pereyrarg11.mobile.core.domain.repository

import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import com.pereyrarg11.mobile.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface AppConfigRepository {
    suspend fun loadConfig(): Flow<Result<Unit>>

    fun getConfig(): AppConfigModel

    /**
     * Provide an entryName for the value you are interested.
     * Omit the entryName if you want to listen to any change.
     */
    suspend fun listenToRealTimeUpdates(entryName: String? = null): Flow<Result<Unit>>
}
