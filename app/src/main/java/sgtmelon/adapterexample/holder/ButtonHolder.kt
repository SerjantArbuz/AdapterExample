package sgtmelon.adapterexample.holder

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Button] inside [TestAdapter].
 */
class ButtonHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val cardContainer = itemView.findViewById<CardView>(R.id.button_card_container)
    private val clickContainer = itemView.findViewById<ViewGroup>(R.id.button_click_container)
    private val textView = itemView.findViewById<TextView>(R.id.button_text)

    fun bind(item: TestItem.Button, callback: Callback) {
        cardContainer.setCardBackgroundColor(context.getColor(item.colorId))
        clickContainer.setOnClickListener { callback.onButtonClick(item) }
        textView.text = context.getString(item.textId)
    }

    override fun unbind() {
        clickContainer.setOnClickListener(null)
    }

    interface Callback {
        fun onButtonClick(item: TestItem.Button)
    }
}