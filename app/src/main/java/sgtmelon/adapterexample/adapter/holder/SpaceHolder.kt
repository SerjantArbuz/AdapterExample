package sgtmelon.adapterexample.adapter.holder

import android.view.View
import sgtmelon.adapterexample.R

import sgtmelon.adapterexample.adapter.SimpleAdapter
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.updateMargin

/**
 * Holder for [TestItem.Space] inside [SimpleAdapter].
 */
class SpaceHolder(itemView: View): ParentHolder(itemView) {

    private val container = itemView.findViewById<View>(R.id.space_container)

    fun bind(item: TestItem.Space) {
        container.updateMargin(top = context.resources.getDimensionPixelSize(item.spaceId))
    }
}