package sgtmelon.adapterexample.model

import androidx.annotation.StringRes

/**
 * Describes list menu item with [classLink] for open new screen.
 */
data class MenuItem(val id: Int, @StringRes val textId: Int, val classLink: Class<*>)