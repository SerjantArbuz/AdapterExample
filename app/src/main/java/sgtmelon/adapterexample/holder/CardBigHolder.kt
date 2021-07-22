package sgtmelon.adapterexample.holder

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Card.Big] inside [TestAdapter].
 */
class CardBigHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val clickContainer = itemView.findViewById<ViewGroup>(R.id.item_big_click_container)
    private val imageView = itemView.findViewById<ImageView>(R.id.item_big_image)

    fun bind(item: TestItem.Card.Big, callback: Callback) {
        clickContainer.setOnClickListener { callback.onCardClick(item) }

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
        fun onCardClick(item: TestItem.Card.Big)
    }
}