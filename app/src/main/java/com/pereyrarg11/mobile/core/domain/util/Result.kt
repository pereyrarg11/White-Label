package com.pereyrarg11.mobile.core.domain.util

sealed interface Result<T> {
    data class Success<T>(
        val data: T,
    ) : Result<T>

    data class Error<T>(
        val exception: Exception? = null,
        val data: T? = null,
    ) : Result<T>

    data class Loading<T>(
        val isLoading: Boolean = false,
    ) : Result<T>
}
