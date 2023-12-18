package com.pereyrarg11.mobile.feature.app_config.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.mobile.core.presentation.screen.MainScreen
import com.pereyrarg11.mobile.feature.app_config.presentation.component.AppConfigContent

/**
 * It shows the app configuration downloaded from the remote source.
 */
@Composable
fun AppConfigScreen(
    modifier: Modifier = Modifier,
    viewModel: AppConfigViewModel = hiltViewModel(),
) {
    MainScreen(
        modifier = modifier
    ) { innerModifier ->
        AppConfigContent(model = viewModel.appConfig, modifier = innerModifier)
    }
}
