package sgtmelon.adapterexample.holder

import android.view.View
import android.widget.TextView
import sgtmelon.adapterexample.R

import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Header] inside [TestAdapter].
 */
class HeaderHolder(itemView: View): TestHolder(itemView) {

    private val titleText = itemView.findViewById<TextView>(R.id.header_title_text)
    private val actionText = itemView.findViewById<TextView>(R.id.header_action_text)

    fun bind(item: TestItem.Header, callback: Callback) {
        val context = itemView.context

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