package com.pereyrarg11.mobile.core.presentation.navigation

import com.pereyrarg11.mobile.core.presentation.navigation.NavConstants.ID_PARAM

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("home")

    object Drink : ScreenRoute("detail/{$ID_PARAM}") {
        fun createRoute(id: String) = "detail/$id"
    }
}
