package sgtmelon.adapterexample.adapter.holder

import androidx.recyclerview.widget.RecyclerView

/**
 * Callback which need call inside [RecyclerView.Adapter.onViewRecycled] for prevent memory leaks.
 */
interface UnbindCallback {
    fun unbind()
}