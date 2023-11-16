package com.pereyrarg11.mobile.core.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.mobile.core.presentation.model.ImageSource
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BaseImage(
    source: ImageSource,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    isPreview: Boolean = LocalInspectionMode.current,
) {
    if (isPreview || source.remoteUrl.isBlank()) {
        Image(
            painter = painterResource(id = source.placeholder),
            contentDescription = source.contentDescription,
            modifier = modifier,
            contentScale = contentScale,
        )
    } else {
        GlideImage(
            model = source.remoteUrl,
            contentDescription = source.contentDescription,
            modifier = modifier,
            contentScale = contentScale,
        )
    }
}

@Preview
@Composable
fun RemoteImagePreview() {
    WhiteLabelTheme {
        BaseImage(
            source = ImageSource(
                contentDescription = "Hello world",
                remoteUrl = "https://storage.googleapis.com/gweb-uniblog-publish-prod/images/2_Android_14_statue.width-1000.format-webp.webp"
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Preview
@Composable
fun CircleImagePreview() {
    WhiteLabelTheme {
        BaseImage(
            source = ImageSource(
                contentDescription = "Hello world",
            ),
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                    CircleShape
                )
                .padding(2.dp)
                .size(100.dp)
        )
    }
}
