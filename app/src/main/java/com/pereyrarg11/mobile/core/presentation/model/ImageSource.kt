package com.pereyrarg11.mobile.core.presentation.model

import androidx.annotation.DrawableRes
import com.pereyrarg11.mobile.R

data class ImageSource(
    val contentDescription: String,
    val remoteUrl: String = "",
    @DrawableRes
    val placeholder: Int = R.drawable.img_placeholder,
    @DrawableRes
    val error: Int = R.drawable.img_placeholder,
)
