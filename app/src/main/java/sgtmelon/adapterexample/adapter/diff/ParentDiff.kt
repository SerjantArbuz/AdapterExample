package sgtmelon.adapterexample.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import sgtmelon.adapterexample.clearAdd

/**
 * Parent class of [DiffUtil.Callback].
 */
abstract class ParentDiff<T> : DiffUtil.Callback() {

    private val oldList: MutableList<T> = ArrayList()
    private val newList: MutableList<T> = ArrayList()

    fun setList(oldList: List<T>, newList: List<T>) {
        this.oldList.clearAdd(oldList)
        this.newList.clearAdd(newList)
    }

    fun getOldItem(position: Int) = oldList.getOrNull(position)

    fun getNewItem(position: Int) = newList.getOrNull(position)

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}