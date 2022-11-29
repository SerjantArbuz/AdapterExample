package sgtmelon.adapterexample.model

import androidx.annotation.StringDef
import sgtmelon.adapterexample.model.ItemId.HeaderId
import sgtmelon.adapterexample.model.ItemId.SpaceId
import sgtmelon.adapterexample.model.ItemId.ButtonId
import sgtmelon.adapterexample.model.ItemId.CardId

/**
 * Unique id's for [Item]
 */
@StringDef(
    HeaderId.FIRST, HeaderId.SECOND, HeaderId.THIRD, HeaderId.FOURTH,
    SpaceId.SMALL, SpaceId.MEDIUM, SpaceId.BIG,
    ButtonId.FIRST, ButtonId.SECOND, ButtonId.THIRD,
    ButtonId.FOURTH, ButtonId.FIFTH, ButtonId.SIXTH,
    CardId.SMALL, CardId.MEDIUM, CardId.BIG
)
annotation class ItemId {

    annotation class HeaderId {
        companion object {
            const val FIRST = "HEADER_FIRST"
            const val SECOND = "HEADER_SECOND"
            const val THIRD = "HEADER_THIRD"
            const val FOURTH = "HEADER_FOURTH"
        }
    }

    annotation class SpaceId {
        companion object {
            const val SMALL = "SPACE_SMALL"
            const val MEDIUM = "SPACE_MEDIUM"
            const val BIG = "SPACE_BIG"
        }
    }

    annotation class ButtonId {
        companion object {
            const val FIRST = "BUTTON_FIRST"
            const val SECOND = "BUTTON_SECOND"
            const val THIRD = "BUTTON_THIRD"
            const val FOURTH = "BUTTON_FOURTH"
            const val FIFTH = "BUTTON_FIFTH"
            const val SIXTH = "BUTTON_SIXTH"
        }
    }

    annotation class CardId {
        companion object {
            const val SMALL = "CARD_SMALL"
            const val MEDIUM = "CARD_MEDIUM"
            const val BIG = "CARD_BIG"
        }
    }
}
