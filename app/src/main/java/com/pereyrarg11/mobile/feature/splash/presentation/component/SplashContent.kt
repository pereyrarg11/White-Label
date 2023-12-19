package com.pereyrarg11.mobile.feature.splash.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.mobile.BuildConfig
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.presentation.components.BaseImage
import com.pereyrarg11.mobile.core.presentation.model.ImageSource
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme

@Composable
fun SplashContent(
    modifier: Modifier = Modifier,
    versionName: String = BuildConfig.VERSION_NAME,
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.size_lg))
    ) {
        BaseImage(
            source = ImageSource(
                contentDescription = stringResource(id = R.string.app_name),
                placeholder = R.drawable.ic_splash
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .size(dimensionResource(id = R.dimen.splash_screen_image_size))
        )

        Text(
            text = "v$versionName",
            modifier = Modifier.align(Alignment.BottomCenter),
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun LightSplashContentPreview() {
    WhiteLabelTheme(darkTheme = false) {
        SplashContent()
    }
}

@Preview
@Composable
fun DarkSplashContentPreview() {
    WhiteLabelTheme(darkTheme = true) {
        SplashContent()
    }
}
