package com.pereyrarg11.mobile.core.presentation.model

import com.pereyrarg11.mobile.core.presentation.util.UiText

/**
 * Interface for all content to be displayed into a detail-screen.
 */
interface UiDetail : Displayable {
    val title: UiText
    val mediaUrl: String
}
