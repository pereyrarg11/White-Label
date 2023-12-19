package com.pereyrarg11.mobile.feature.home.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pereyrarg11.mobile.core.presentation.screen.MainScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    MainScreen(
        modifier = modifier,
    ) { innerModifier ->
        HomeSuccessScreen(modifier = innerModifier)
    }
}
