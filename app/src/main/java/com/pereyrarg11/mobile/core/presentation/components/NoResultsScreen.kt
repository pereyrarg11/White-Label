package com.pereyrarg11.mobile.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme
import com.pereyrarg11.mobile.core.presentation.util.UiText

@Composable
fun NoResultsScreen(
    modifier: Modifier = Modifier,
    message: UiText = UiText.StringResource(R.string.error_no_results),
) {
    FeedbackScreen(
        message = message,
        imageVector = Icons.Default.List,
        modifier = modifier,
    )
}

@Preview
@Composable
fun NoResultsScreenPreview() {
    WhiteLabelTheme {
        NoResultsScreen()
    }
}
