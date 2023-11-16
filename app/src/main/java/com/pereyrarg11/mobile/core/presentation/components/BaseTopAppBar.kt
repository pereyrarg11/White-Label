package com.pereyrarg11.mobile.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme
import com.pereyrarg11.mobile.core.presentation.util.UiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(
    modifier: Modifier = Modifier,
    title: UiText = UiText.PlainText(""),
    onBackPressed: () -> Unit = {},
) {
    TopAppBar(
        title = { Text(text = title.asString()) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.action_back)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

@Preview
@Composable
fun DetailAppBarPreview() {
    WhiteLabelTheme {
        DetailAppBar(title = UiText.PlainText("DetailAppBar"))
    }
}
