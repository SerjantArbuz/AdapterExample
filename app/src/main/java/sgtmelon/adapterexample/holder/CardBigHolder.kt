package sgtmelon.adapterexample.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Card.Big] inside [TestAdapter].
 */
class CardBigHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    fun bind(item: TestItem.Card.Big, callback: Callback) {
        TODO("Not yet implemented")
    }

    override fun unbind() {
        TODO("Not yet implemented")
    }

    interface Callback {
        fun onCardClick(item: TestItem.Card.Big)
    }
}