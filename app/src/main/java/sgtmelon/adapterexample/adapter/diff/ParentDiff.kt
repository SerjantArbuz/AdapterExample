package sgtmelon.adapterexample.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import sgtmelon.adapterexample.clearAdd

/**
 * Parent class of [DiffUtil.Callback].
 */
abstract class ParentDiff<T> : DiffUtil.Callback() {

    protected val oldList: MutableList<T> = ArrayList()
    protected val newList: MutableList<T> = ArrayList()

    fun setList(oldList: List<T>, newList: List<T>) {
        this.oldList.clearAdd(oldList)
        this.newList.clearAdd(newList)
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}