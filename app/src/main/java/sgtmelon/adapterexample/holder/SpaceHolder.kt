package sgtmelon.adapterexample.holder

import android.view.View

import sgtmelon.adapterexample.TestAdapter
import sgtmelon.adapterexample.model.TestItem

/**
 * Holder for [TestItem.Space] inside [TestAdapter].
 */
class SpaceHolder(itemView: View): TestHolder(itemView) {

    fun bind(item: TestItem.Space) {
        TODO("Not yet implemented")
    }

    override fun unbind() = Unit
}