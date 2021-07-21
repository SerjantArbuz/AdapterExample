package sgtmelon.adapterexample

import android.view.ViewGroup
import sgtmelon.adapterexample.holder.*
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.model.TestType

class TestAdapter : ParentAdapter<TestItem, TestHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TestType.HEADER -> HeaderHolder(parent.inflate(R.layout.item_header))
        TestType.SPACE -> SpaceHolder(parent.inflate(R.layout.item_space))
        TestType.BUTTON -> ButtonHolder(parent.inflate(R.layout.item_button))
        TestType.CARD_SMALL -> CardSmallHolder(parent.inflate(R.layout.item_card_small))
        TestType.CARD_MEDIUM -> CardMediumHolder(parent.inflate(R.layout.item_card_medium))
        else -> CardBigHolder(parent.inflate(R.layout.item_card_big))
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        when (val item = list.getOrNull(position)) {
            is TestItem.Header -> (holder as? HeaderHolder)?.bind(item)
            is TestItem.Space -> (holder as? SpaceHolder)?.bind(item)
            is TestItem.Button -> (holder as? ButtonHolder)?.bind(item)
            is TestItem.Card.Small -> (holder as? CardSmallHolder)?.bind(item)
            is TestItem.Card.Medium -> (holder as? CardMediumHolder)?.bind(item)
            is TestItem.Card.Big -> (holder as? CardBigHolder)?.bind(item)
        }
    }

    override fun onViewRecycled(holder: TestHolder) {
        super.onViewRecycled(holder)
        holder.unbind()
    }

    override fun getItemViewType(position: Int): Int = list[position].type

}