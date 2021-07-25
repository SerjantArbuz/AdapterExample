package sgtmelon.adapterexample.holder

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Item.Small] inside [TestAdapter].
 */
class SmallItemHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val contentContainer = itemView.findViewById<ViewGroup>(R.id.item_small_container)
    private val imageView = itemView.findViewById<ImageView>(R.id.item_small_image)
    private val titleText = itemView.findViewById<TextView>(R.id.item_small_title)
    private val subtitleText = itemView.findViewById<TextView>(R.id.item_small_subtitle)

    fun bind(item: TestItem.Item.Small, callback: Callback) {
        contentContainer.setOnClickListener { callback.onItemClick(item) }

        Glide.with(context)
            .load(item.imageUrl)
            .placeholder(ColorDrawable(context.getColor(R.color.load_holder)))
            .error(ColorDrawable(context.getColor(R.color.load_error)))
            .into(imageView)

        titleText.text = item.title
        subtitleText.text = item.subtitle
    }

    override fun unbind() {
        contentContainer.setOnClickListener(null)
    }

    interface Callback {
        fun onItemClick(item: TestItem.Item.Small)
    }
}