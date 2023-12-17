package com.pereyrarg11.mobile.feature.splash.domain.usecase

import com.pereyrarg11.mobile.core.domain.repository.AppConfigRepository
import com.pereyrarg11.mobile.core.domain.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadAppConfigUseCase @Inject constructor(
    private val repository: AppConfigRepository,
) {

    suspend operator fun invoke(): Flow<Result<Unit>> = repository.loadConfig()
}
