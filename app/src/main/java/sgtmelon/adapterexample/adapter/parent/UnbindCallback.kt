package sgtmelon.adapterexample.adapter.parent

import androidx.recyclerview.widget.RecyclerView

/**
 * This interface needed for preventing memory leaks. Implement this interface in
 * your [RecyclerView.ViewHolder] and remove any listeners from views inside [unbind] realization.
 *
 * Call [unbind] from [RecyclerView.Adapter.onViewRecycled].
 */
interface UnbindCallback {
    fun unbind()
}