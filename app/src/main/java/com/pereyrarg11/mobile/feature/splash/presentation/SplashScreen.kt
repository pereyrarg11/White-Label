package com.pereyrarg11.mobile.feature.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pereyrarg11.mobile.core.presentation.navigation.ScreenRoute
import com.pereyrarg11.mobile.feature.splash.presentation.component.SplashContent
import com.pereyrarg11.mobile.feature.splash.presentation.model.SplashUiEvent

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEventFlow.collect { uiEvent ->
            when (uiEvent) {
                is SplashUiEvent.ShowError -> {}
                SplashUiEvent.ConfigurationLoaded -> {
                    navController.navigate(ScreenRoute.AppConfig.route) {
                        popUpTo(ScreenRoute.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
    SplashContent(modifier = modifier)
}
