package sgtmelon.adapterexample.adapter.holder

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.SimpleAdapter
import sgtmelon.adapterexample.model.Item

/**
 * Holder for [Item.Button] inside [SimpleAdapter].
 */
class ButtonHolder(itemView: View): ParentHolder(itemView), UnbindCallback {

    private val cardContainer = itemView.findViewById<CardView>(R.id.button_card_container)
    private val clickContainer = itemView.findViewById<ViewGroup>(R.id.button_click_container)
    private val imageView = itemView.findViewById<ImageView>(R.id.button_image)
    private val textView = itemView.findViewById<TextView>(R.id.button_text)

    fun bind(item: Item.Button, callback: Callback) {
        cardContainer.setCardBackgroundColor(context.getColor(item.colorId))
        clickContainer.setOnClickListener { callback.onButtonClick(item) }

        Glide.with(context)
            .load(item.imageUrl)
            .placeholder(ColorDrawable(context.getColor(R.color.load_holder)))
            .error(ColorDrawable(context.getColor(R.color.load_error)))
            .into(imageView)

        textView.text = context.getString(item.textId)
    }

    override fun unbind() {
        clickContainer.setOnClickListener(null)
    }

    interface Callback {
        fun onButtonClick(item: Item.Button)
    }
}