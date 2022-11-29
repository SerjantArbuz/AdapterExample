package sgtmelon.adapterexample.cleanup.adapter.holder

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.cleanup.adapter.SimpleAdapter
import sgtmelon.adapterexample.model.Item

/**
 * Holder for [Item.Card.Big] inside [SimpleAdapter].
 */
class BigItemHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val clickContainer = itemView.findViewById<ViewGroup>(R.id.item_big_click_container)
    private val imageView = itemView.findViewById<ImageView>(R.id.item_big_image)

    fun bind(item: Item.Card.Big, callback: Callback) {
        clickContainer.setOnClickListener { callback.onItemClick(item) }

        Glide.with(context)
            .load(item.imageUrl)
            .placeholder(ColorDrawable(context.getColor(R.color.load_holder)))
            .error(ColorDrawable(context.getColor(R.color.load_error)))
            .into(imageView)
    }

    override fun unbind() {
        clickContainer.setOnClickListener(null)
    }

    interface Callback {
        fun onItemClick(item: Item.Card.Big)
    }
}