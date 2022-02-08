package sgtmelon.adapterexample.adapter.diff

import sgtmelon.adapterexample.adapter.DiffAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Diff for [DiffAdapter].
 */
class TestDiff : ParentDiff<TestItem>() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = getOldItem(oldItemPosition) ?: return false
        val newItem = getNewItem(newItemPosition) ?: return false

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = getOldItem(oldItemPosition) ?: return false
        val newItem = getNewItem(newItemPosition) ?: return false

        return oldItem == newItem
    }
}