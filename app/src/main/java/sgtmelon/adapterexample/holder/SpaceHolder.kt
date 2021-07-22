package sgtmelon.adapterexample.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R

import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.updateMargin

/**
 * Holder for [TestItem.Space] inside [TestAdapter].
 */
class SpaceHolder(itemView: View): ParentHolder(itemView) {

    private val container = itemView.findViewById<View>(R.id.space_container)

    fun bind(item: TestItem.Space) {
        container.updateMargin(top = context.resources.getDimensionPixelSize(item.spaceId))
    }
}