package com.pereyrarg11.mobile.feature.home.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme

@Composable
fun HomeSuccessScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Preview
@Composable
fun HomeSuccessScreenPreview() {
    WhiteLabelTheme {
        HomeSuccessScreen()
    }
}
