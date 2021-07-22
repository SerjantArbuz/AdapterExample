package sgtmelon.adapterexample.holder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Card.Small] inside [TestAdapter].
 */
class CardSmallHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val contentContainer = itemView.findViewById<ViewGroup>(R.id.item_small_container)
    private val imageView = itemView.findViewById<ImageView>(R.id.item_small_image)
    private val titleText = itemView.findViewById<TextView>(R.id.item_small_title)
    private val subtitleText = itemView.findViewById<TextView>(R.id.item_small_subtitle)

    fun bind(item: TestItem.Card.Small, callback: Callback) {
        contentContainer.setOnClickListener { callback.onCardClick(item) }

        // TODO glide
        imageView

        titleText.text = item.title
        subtitleText.text = item.subtitle
    }

    override fun unbind() {
        contentContainer.setOnClickListener(null)
    }

    interface Callback {
        fun onCardClick(item: TestItem.Card.Small)
    }
}