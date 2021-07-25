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
        val imageUrl: String,
        @StringRes val textId: Int,
        @ColorRes val colorId: Int,
    ) : TestItem(TestType.BUTTON) {
        class First(imageUrl: String) : Button(imageUrl, R.string.button_first, R.color.button_first)
        class Second(imageUrl: String) : Button(imageUrl, R.string.button_second, R.color.button_second)
        class Third(imageUrl: String) : Button(imageUrl, R.string.button_third, R.color.button_third)
        class Fourth(imageUrl: String) : Button(imageUrl, R.string.button_fourth, R.color.button_fourth)
        class Fifth(imageUrl: String) : Button(imageUrl, R.string.button_fifth, R.color.button_fifth)
        class Sixth(imageUrl: String) : Button(imageUrl, R.string.button_sixth, R.color.button_sixth)
    }

    sealed class Item(val imageUrl: String, @TestType type: Int, ) : TestItem(type) {

        class Small(imageUrl: String, val title: String, val subtitle: String) :
            Item(imageUrl, TestType.CARD_SMALL)

        class Medium(imageUrl: String, val title: String, val subtitle: String) :
            Item(imageUrl, TestType.CARD_MEDIUM)

        class Big(imageUrl: String) : Item(imageUrl, TestType.CARD_BIG)
    }

}