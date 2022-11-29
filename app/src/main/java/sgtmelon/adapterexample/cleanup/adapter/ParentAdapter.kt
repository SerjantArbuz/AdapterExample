package sgtmelon.adapterexample.cleanup.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Parent abstract class for adapters with common functions.
 *
 * [T]  - list model
 * [VH] - holder for model
 */
abstract class ParentAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    protected val list: MutableList<T> = ArrayList()

    fun setList(list: List<T>): ParentAdapter<T, VH> = apply {
        this.list.clear()
        this.list.addAll(list)
    }

    fun setItem(index: Int, item: T): ParentAdapter<T, VH> = apply {
        if (index !in list.indices) return@apply

        list[index] = item
    }

    fun getItemList(): MutableList<T> = list

    override fun getItemCount() = list.size
}
