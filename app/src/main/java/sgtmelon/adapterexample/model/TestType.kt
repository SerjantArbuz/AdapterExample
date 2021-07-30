package sgtmelon.adapterexample.model

import androidx.annotation.IntDef

@IntDef(
    TestType.HEADER, TestType.SPACE, TestType.BUTTON,
    TestType.ITEM_SMALL, TestType.ITEM_MEDIUM, TestType.ITEM_BIG
)
annotation class TestType {
    companion object {
        const val HEADER = 0
        const val SPACE = 1
        const val BUTTON = 2
        const val ITEM_SMALL = 3
        const val ITEM_MEDIUM = 4
        const val ITEM_BIG = 5
    }
}