package sgtmelon.adapterexample.cleanup.adapter.holder

import android.view.View
import sgtmelon.adapterexample.R

import sgtmelon.adapterexample.cleanup.adapter.SimpleAdapter
import sgtmelon.adapterexample.model.Item
import sgtmelon.adapterexample.updateMargin

/**
 * Holder for [Item.Space] inside [SimpleAdapter].
 */
class SpaceHolder(itemView: View): ParentHolder(itemView) {

    private val container = itemView.findViewById<View>(R.id.space_container)

    fun bind(item: Item.Space) {
        container.updateMargin(top = context.resources.getDimensionPixelSize(item.spaceId))
    }
}