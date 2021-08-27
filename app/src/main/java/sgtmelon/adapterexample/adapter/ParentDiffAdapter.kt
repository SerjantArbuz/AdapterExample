package sgtmelon.adapterexample.adapter

import androidx.annotation.CallSuper
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.adapter.diff.ParentDiff

/**
 * Parent abstract class for adapters with common functions
 *
 * @param <T>   - list model
 * @param <D>   - diff callback
 * @param <VH>  - holder for model
 */
abstract class ParentDiffAdapter<T, D : ParentDiff<T>, VH : RecyclerView.ViewHolder> :
        RecyclerView.Adapter<VH>() {

    private var diffResult: DiffUtil.DiffResult? = null

    protected val list: MutableList<T> = ArrayList()

    abstract val diff: D

    fun notifyList(list: List<T>) {
        this.list.clear()
        this.list.addAll(list)

        diff.setList(this.list, list)
        diffResult = DiffUtil.calculateDiff(diff)
        diffResult?.dispatchUpdatesTo(this)
    }

    fun getItemList(): MutableList<T> = list

    override fun getItemCount() = list.size

}