package sgtmelon.adapterexample.model

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.DiffAdapter
import sgtmelon.adapterexample.adapter.SimpleAdapter
import sgtmelon.adapterexample.adapter.diff.TestDiff
import sgtmelon.adapterexample.model.ItemId.*

/**
 * Model's for [SimpleAdapter] and [DiffAdapter].
 *
 * [id] - is unique string for identify items inside [TestDiff]/[DiffAdapter].
 */
sealed class Item(val id: String, val type: ItemType) {

    sealed class Header(
        id: String,
        @StringRes val titleId: Int,
        @StringRes val actionId: Int? = null,
    ) : Item(id, ItemType.HEADER) {

        object First : Header(HeaderId.FIRST, R.string.header_first)
        object Second : Header(HeaderId.SECOND, R.string.header_second, R.string.action_second)
        object Third : Header(HeaderId.THIRD, R.string.header_third)
        object Fourth : Header(HeaderId.FOURTH, R.string.header_fourth, R.string.action_fourth)
    }

    sealed class Space(id: String, @DimenRes val spaceId: Int) : Item(id, ItemType.SPACE) {

        object Small : Space(SpaceId.SMALL, R.dimen.space_small)
        object Medium : Space(SpaceId.MEDIUM, R.dimen.space_medium)
        object Big : Space(SpaceId.BIG, R.dimen.space_big)
    }

    sealed class Button(
        id: String,
        val imageUrl: String,
        @StringRes val textId: Int,
        @ColorRes val colorId: Int,
    ) : Item(id, ItemType.BUTTON) {

        class First(imageUrl: String) :
            Button(ButtonId.FIRST, imageUrl, R.string.button_first, R.color.button_first)

        class Second(imageUrl: String) :
            Button(ButtonId.SECOND, imageUrl, R.string.button_second, R.color.button_second)

        class Third(imageUrl: String) :
            Button(ButtonId.THIRD, imageUrl, R.string.button_third, R.color.button_third)

        class Fourth(imageUrl: String) :
            Button(ButtonId.FOURTH, imageUrl, R.string.button_fourth, R.color.button_fourth)

        class Fifth(imageUrl: String) :
            Button(ButtonId.FIFTH, imageUrl, R.string.button_fifth, R.color.button_fifth)

        class Sixth(imageUrl: String) :
            Button(ButtonId.SIXTH, imageUrl, R.string.button_sixth, R.color.button_sixth)
    }

    sealed class Card(id: String, type: ItemType) : Item(id, type) {

        data class Small(
            val uniqueId: String,
            val imageUrl: String,
            val title: String,
            val subtitle: String,
        ) : Card(CardId.SMALL.plus(uniqueId), ItemType.ITEM_SMALL)

        data class Medium(
            val uniqueId: String,
            var imageUrl: String,
            var title: String,
            var subtitle: String,
        ) : Card(CardId.MEDIUM.plus(uniqueId), ItemType.ITEM_MEDIUM)

        data class Big(val uniqueId: String, val imageUrl: String) :
            Card(CardId.BIG.plus(uniqueId), ItemType.ITEM_BIG)
    }
}