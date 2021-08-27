package sgtmelon.adapterexample.adapter.diff

import sgtmelon.adapterexample.adapter.DiffAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Diff for [DiffAdapter]
 */
class TestDiff : ParentDiff<TestItem>() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList.getOrNull(oldItemPosition) ?: return false
        val newItem = newList.getOrNull(newItemPosition) ?: return false

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList.getOrNull(oldItemPosition) ?: return false
        val newItem = newList.getOrNull(newItemPosition) ?: return false

        when (oldItem) {
            is TestItem.Header.First -> return newItem is TestItem.Header.First
            is TestItem.Header.Second -> return newItem is TestItem.Header.Second
            is TestItem.Header.Third -> return newItem is TestItem.Header.Third
            is TestItem.Header.Fourth -> return newItem is TestItem.Header.Fourth
            is TestItem.Space.Small -> return newItem is TestItem.Space.Small
            is TestItem.Space.Medium -> return newItem is TestItem.Space.Medium
            is TestItem.Space.Big -> return newItem is TestItem.Space.Big
            is TestItem.Button.First -> return newItem is TestItem.Button.First
            is TestItem.Button.Second -> return newItem is TestItem.Button.Second
            is TestItem.Button.Third -> return newItem is TestItem.Button.Third
            is TestItem.Button.Fourth -> return newItem is TestItem.Button.Fourth
            is TestItem.Button.Fifth -> return newItem is TestItem.Button.Fifth
            is TestItem.Button.Sixth -> return newItem is TestItem.Button.Sixth
            is TestItem.Item.Small -> {
                if (newItem !is TestItem.Item.Small) return false

                return oldItem.imageUrl == newItem.imageUrl &&
                        oldItem.title == newItem.title &&
                        oldItem.subtitle == newItem.subtitle
            }
            is TestItem.Item.Medium -> {
                if (newItem !is TestItem.Item.Medium) return false

                return oldItem.imageUrl == newItem.imageUrl &&
                        oldItem.title == newItem.title &&
                        oldItem.subtitle == newItem.subtitle
            }
            is TestItem.Item.Big -> {
                if (newItem !is TestItem.Item.Big) return false

                return oldItem.imageUrl == newItem.imageUrl
            }
        }
    }
}