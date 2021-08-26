package sgtmelon.adapterexample.adapter.diff

import sgtmelon.adapterexample.adapter.DiffAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Diff for [DiffAdapter]
 */
class TestDiff : ParentDiff<TestItem>() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}