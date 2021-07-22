package sgtmelon.adapterexample.model

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.TestAdapter

/**
 * Model's for [TestAdapter].
 */
sealed class TestItem(@TestType val type: Int) {

    sealed class Header(
        @StringRes val titleId: Int,
        @StringRes val actionId: Int? = null,
    ) : TestItem(TestType.HEADER) {
        object First : Header(R.string.header_first)
        object Second : Header(R.string.header_second, R.string.action_second)
        object Third : Header(R.string.header_third)
        object Fourth : Header(R.string.header_fourth, R.string.action_fourth)
    }

    sealed class Space(@DimenRes val spaceId: Int) : TestItem(TestType.SPACE) {
        object Small : Space(R.dimen.space_small)
        object Medium : Space(R.dimen.space_medium)
        object Big : Space(R.dimen.space_big)
    }

    sealed class Button(
        @StringRes val textId: Int,
        @ColorRes val colorId: Int,
    ) : TestItem(TestType.BUTTON) {
        object First : Button(R.string.button_first, R.color.button_first)
        object Second : Button(R.string.button_second, R.color.button_second)
        object Third : Button(R.string.button_third, R.color.button_third)
        object Fourth : Button(R.string.button_fourth, R.color.button_fourth)
    }

    sealed class Card(val imageUrl: String, @TestType type: Int, ) : TestItem(type) {

        class Small(imageUrl: String, val title: String, val subtitle: String) :
            Card(imageUrl, TestType.CARD_SMALL)

        class Medium(imageUrl: String, val title: String, val subtitle: String) :
            Card(imageUrl, TestType.CARD_MEDIUM)

        class Big(imageUrl: String) : Card(imageUrl, TestType.CARD_BIG)
    }

}