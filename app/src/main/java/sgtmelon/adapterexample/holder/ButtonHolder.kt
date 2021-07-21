package sgtmelon.adapterexample.holder

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Button] inside [TestAdapter].
 */
class ButtonHolder(itemView: View): TestHolder(itemView) {

    private val cardContainer = itemView.findViewById<CardView>(R.id.button_card_container)
    private val clickContainer = itemView.findViewById<CardView>(R.id.button_click_container)
    private val textView = itemView.findViewById<TextView>(R.id.button_text)

    fun bind(item: TestItem.Button, callback: Callback) {
        val context = itemView.context

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