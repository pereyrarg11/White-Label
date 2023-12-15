package com.pereyrarg11.mobile.core.presentation.model

import com.pereyrarg11.mobile.core.presentation.util.UiText

/**
 * Contains the minimum attributes which an item must have in order to be displayed into a list.
 * All list-item data MUST implement this interface.
 */
interface UiItem : Displayable {
    val id: String
    val label: UiText
    val imageUrl: String
}
