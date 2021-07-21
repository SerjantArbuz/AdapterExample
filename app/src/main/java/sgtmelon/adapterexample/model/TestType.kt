package sgtmelon.adapterexample.model

import androidx.annotation.IntDef

@IntDef(
    TestType.HEADER,
    TestType.SPACE,
    TestType.BUTTON,
    TestType.CARD_SMALL,
    TestType.CARD_MEDIUM,
    TestType.CARD_BIG
)
annotation class TestType {
    companion object {
        const val HEADER = 0
        const val SPACE = 1
        const val BUTTON = 2
        const val CARD_SMALL = 3
        const val CARD_MEDIUM = 4
        const val CARD_BIG = 5
    }
}