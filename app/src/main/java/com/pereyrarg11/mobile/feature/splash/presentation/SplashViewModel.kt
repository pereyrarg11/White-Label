package com.pereyrarg11.mobile.feature.splash.presentation

import androidx.lifecycle.viewModelScope
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.domain.util.Result
import com.pereyrarg11.mobile.core.logger.error.ErrorLogger
import com.pereyrarg11.mobile.core.presentation.BaseViewModel
import com.pereyrarg11.mobile.core.presentation.model.UiEvent
import com.pereyrarg11.mobile.core.presentation.util.UiText
import com.pereyrarg11.mobile.feature.splash.domain.usecase.LoadAppConfigUseCase
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

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow = _uiEventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            loadAppConfigUseCase().collect { result ->
                when (result) {
                    is Result.Error -> {
                        handleError(result.exception)
                        _uiEventFlow.emit(UiEvent.ShowError(UiText.StringResource(R.string.error_default)))
                    }

                    is Result.Loading -> _uiEventFlow.emit(UiEvent.ShowLoading(result.isLoading))
                    is Result.Success -> _uiEventFlow.emit(UiEvent.Success)
                }
            }
        }
    }

    override fun handleError(exception: Exception?) {
        if (exception != null) logException(exception)
    }
}
