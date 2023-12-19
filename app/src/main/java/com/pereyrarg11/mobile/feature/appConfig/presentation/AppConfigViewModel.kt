package com.pereyrarg11.mobile.feature.appConfig.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.mobile.core.domain.repository.AppConfigRepository
import com.pereyrarg11.mobile.core.domain.util.Result
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.presentation.BaseViewModel
import com.pereyrarg11.mobile.feature.appConfig.presentation.model.AppConfigUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppConfigViewModel @Inject constructor(
    errorLogger: ErrorLogger,
    appConfigRepository: AppConfigRepository,
) : BaseViewModel(errorLogger) {

    var uiState by mutableStateOf(AppConfigUiState(appConfig = appConfigRepository.getConfig()))

    init {
        viewModelScope.launch {
            appConfigRepository.listenToRealTimeUpdates().collect { result ->
                when (result) {
                    is Result.Error -> handleError(result.exception)
                    is Result.Loading -> {/*nothing to do*/
                    }

                    is Result.Success -> {
                        uiState = uiState.copy(
                            appConfig = appConfigRepository.getConfig()
                        )
                    }
                }
            }
        }
    }

    override fun handleError(exception: Exception?) {
        if (exception != null) logException(exception)
    }
}
