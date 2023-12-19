package com.pereyrarg11.mobile.feature.splash.presentation

import androidx.lifecycle.viewModelScope
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.domain.util.Result
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.presentation.BaseViewModel
import com.pereyrarg11.mobile.core.presentation.util.UiText
import com.pereyrarg11.mobile.feature.splash.domain.usecase.LoadAppConfigUseCase
import com.pereyrarg11.mobile.feature.splash.presentation.model.SplashUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    errorLogger: ErrorLogger,
    private val loadAppConfigUseCase: LoadAppConfigUseCase,
) : BaseViewModel(errorLogger) {

    private val _uiEventFlow = MutableSharedFlow<SplashUiEvent>()
    val uiEventFlow = _uiEventFlow.asSharedFlow()

    // this is the best place to define what is the most appropriate screen to be redirected,
    // e.g. to LoginScreen if user has not an active session
    init {
        viewModelScope.launch {
            loadAppConfigUseCase().collect { result ->
                when (result) {
                    is Result.Error -> {
                        handleError(result.exception)
                        _uiEventFlow.emit(
                            SplashUiEvent.ShowError(
                                UiText.StringResource(R.string.error_default)
                            )
                        )
                    }

                    is Result.Loading -> {
                    }

                    is Result.Success -> _uiEventFlow.emit(SplashUiEvent.ConfigurationLoaded)
                }
            }
        }
    }

    override fun handleError(exception: Exception?) {
        if (exception != null) logException(exception)
    }
}
