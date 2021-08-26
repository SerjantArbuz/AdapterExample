package sgtmelon.adapterexample.model

import androidx.annotation.StringDef
import sgtmelon.adapterexample.model.TestId.HeaderId
import sgtmelon.adapterexample.model.TestId.SpaceId
import sgtmelon.adapterexample.model.TestId.ButtonId
import sgtmelon.adapterexample.model.TestId.ItemId

/**
 * Unique id's for [TestItem]
 */
@StringDef(
    HeaderId.FIRST, HeaderId.SECOND, HeaderId.THIRD, HeaderId.FOURTH,
    SpaceId.SMALL, SpaceId.MEDIUM, SpaceId.BIG,
    ButtonId.FIRST, ButtonId.SECOND, ButtonId.THIRD, ButtonId.FOURTH, ButtonId.FIFTH, ButtonId.SIXTH,
    ItemId.SMALL, ItemId.MEDIUM, ItemId.BIG
)
annotation class TestId {

    annotation class HeaderId {
        companion object {
            private const val PREFIX = "HEADER"

            const val FIRST = "${PREFIX}_FIRST"
            const val SECOND = "${PREFIX}_SECOND"
            const val THIRD = "${PREFIX}_THIRD"
            const val FOURTH = "${PREFIX}_FOURTH"
        }
    }

    annotation class SpaceId {
        companion object {
            private const val PREFIX = "SPACE"

            const val SMALL = "${PREFIX}_SMALL"
            const val MEDIUM = "${PREFIX}_MEDIUM"
            const val BIG = "${PREFIX}_BIG"
        }
    }

    annotation class ButtonId {
        companion object {
            private const val PREFIX = "BUTTON"

            const val FIRST = "${PREFIX}_FIRST"
            const val SECOND = "${PREFIX}_SECOND"
            const val THIRD = "${PREFIX}_THIRD"
            const val FOURTH = "${PREFIX}_FOURTH"
            const val FIFTH = "${PREFIX}_FIFTH"
            const val SIXTH = "${PREFIX}_SIXTH"
        }
    }

    annotation class ItemId {
        companion object {
            private const val PREFIX = "ITEM"

            const val SMALL = "${PREFIX}_SMALL_"
            const val MEDIUM = "${PREFIX}_MEDIUM_"
            const val BIG = "${PREFIX}_BIG_"
        }
    }
}
