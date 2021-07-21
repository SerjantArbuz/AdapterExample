package sgtmelon.adapterexample.holder

import android.view.View
import sgtmelon.adapterexample.R

import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.updateMargin

/**
 * Holder for [TestItem.Space] inside [TestAdapter].
 */
class SpaceHolder(itemView: View): TestHolder(itemView) {

    private val container = itemView.findViewById<View>(R.id.space_container)

    fun bind(item: TestItem.Space) {
        val resources = itemView.context.resources
        container.updateMargin(top = resources.getDimensionPixelSize(item.spaceId))
    }

    override fun unbind() = Unit
}