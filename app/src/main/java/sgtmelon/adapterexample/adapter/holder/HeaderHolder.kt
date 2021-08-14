package sgtmelon.adapterexample.adapter.holder

import android.view.View
import android.widget.TextView
import sgtmelon.adapterexample.R

import sgtmelon.adapterexample.adapter.SimpleAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Header] inside [SimpleAdapter].
 */
class HeaderHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val titleText = itemView.findViewById<TextView>(R.id.header_title_text)
    private val actionText = itemView.findViewById<TextView>(R.id.header_action_text)

    fun bind(item: TestItem.Header, callback: Callback) {
        titleText.text = context.getString(item.titleId)

        if (item.actionId != null) {
            actionText.visibility = View.VISIBLE
            actionText.text = context.getString(item.actionId)
            actionText.setOnClickListener { callback.onHeaderActionClick(item) }
        } else {
            actionText.visibility = View.GONE
        }
    }

    override fun unbind() {
        actionText.setOnClickListener(null)
    }

    interface Callback {
        fun onHeaderActionClick(item: TestItem.Header)
    }
}