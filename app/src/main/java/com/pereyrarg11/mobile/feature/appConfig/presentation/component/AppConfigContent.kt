package com.pereyrarg11.mobile.feature.appConfig.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.mobile.R
import com.pereyrarg11.mobile.core.data.remote.dto.AppConfigKeys
import com.pereyrarg11.mobile.core.domain.model.AppConfigModel
import com.pereyrarg11.mobile.core.presentation.theme.WhiteLabelTheme

@Composable
fun AppConfigContent(
    model: AppConfigModel,
    modifier: Modifier = Modifier,
) {
    val configs = listOf(
        AppConfigKeys.CONTACT_INFO to model.contactInfoJson,
        AppConfigKeys.DEVELOPER_NICKNAME to model.developerNickname,
        AppConfigKeys.STARS to model.stars.toString(),
        AppConfigKeys.SHOW_CONTACT_INFO to model.showContactInfo.toString(),
    )
    val padding = dimensionResource(id = R.dimen.size_md)

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(padding),
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        items(configs) { config ->
            Column {
                Text(text = config.first, fontWeight = FontWeight.Bold)
                Text(text = config.second)
            }
        }
    }
}

@Preview
@Composable
fun AppConfigContentPreview() {
    WhiteLabelTheme {
        AppConfigContent(
            model = AppConfigModel(
                developerNickname = "Gabriel",
                showContactInfo = false,
                stars = 15,
            )
        )
    }
}
