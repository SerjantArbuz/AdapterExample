package sgtmelon.adapterexample

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Model's for [TestAdapter].
 */
sealed class TestItem {

    sealed class Header(
        @StringRes val titleId: Int,
        @StringRes val actionId: Int? = null,
    ) : TestItem() {
        object First : Header(R.string.header_first)
        object Second : Header(R.string.header_second, R.string.action_second)
        object Third : Header(R.string.header_third)
        object Fourth : Header(R.string.header_fourth, R.string.action_fourth)
    }

    sealed class Space(@DimenRes val spaceId: Int) : TestItem() {
        object Small : Space(R.dimen.space_small)
        object Medium : Space(R.dimen.space_medium)
        object Big : Space(R.dimen.space_big)
    }

    sealed class Button(
        @StringRes val textId: Int,
        @ColorRes val colorId: Int,
    ) : TestItem() {
        object First : Button(R.string.button_first, R.color.button_first)
        object Second : Button(R.string.button_second, R.color.button_second)
        object Third : Button(R.string.button_third, R.color.button_third)
    }

    sealed class Card(val imgUrl: String, val title: String,val subtitle: String): TestItem() {
        class Small(imgUrl: String, title: String, subtitle: String): Card(imgUrl, title, subtitle)
        class Medium(imgUrl: String, title: String, subtitle: String): Card(imgUrl, title, subtitle)
        class Big(imgUrl: String, title: String, subtitle: String): Card(imgUrl, title, subtitle)
    }

}