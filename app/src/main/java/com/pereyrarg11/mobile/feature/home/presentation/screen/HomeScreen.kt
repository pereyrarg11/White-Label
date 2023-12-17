package com.pereyrarg11.mobile.feature.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.mobile.core.presentation.screen.MainScreen
import com.pereyrarg11.mobile.feature.home.presentation.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    MainScreen(
        modifier = modifier,
    ) { innerModifier ->
        HomeSuccessScreen(
            message = "hello ${viewModel.developerName}!",
            modifier = innerModifier
        )
    }
}
