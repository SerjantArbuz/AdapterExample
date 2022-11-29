package sgtmelon.adapterexample.cleanup.adapter.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ParentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected val context: Context get() = itemView.context

}