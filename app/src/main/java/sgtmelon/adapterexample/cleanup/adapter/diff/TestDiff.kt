package sgtmelon.adapterexample.cleanup.adapter.diff

import sgtmelon.adapterexample.cleanup.adapter.DiffAdapter
import sgtmelon.adapterexample.model.Item

/**
 * Diff for [DiffAdapter].
 */
class TestDiff : ParentDiff<Item>() {

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