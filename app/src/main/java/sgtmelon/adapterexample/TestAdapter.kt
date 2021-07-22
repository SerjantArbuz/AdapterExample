package sgtmelon.adapterexample

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.holder.*
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.model.TestType

class TestAdapter(
    private val callback: Callback
) : ParentAdapter<TestItem, RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TestType.HEADER -> HeaderHolder(parent.inflate(R.layout.item_header))
        TestType.SPACE -> SpaceHolder(parent.inflate(R.layout.item_space))
        TestType.BUTTON -> ButtonHolder(parent.inflate(R.layout.item_button))
        TestType.CARD_SMALL -> CardSmallHolder(parent.inflate(R.layout.item_small))
        TestType.CARD_MEDIUM -> CardMediumHolder(parent.inflate(R.layout.item_medium))
        else -> CardBigHolder(parent.inflate(R.layout.item_big))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = list.getOrNull(position)) {
            is TestItem.Header -> (holder as? HeaderHolder)?.bind(item, callback)
            is TestItem.Space -> (holder as? SpaceHolder)?.bind(item)
            is TestItem.Button -> (holder as? ButtonHolder)?.bind(item, callback)
            is TestItem.Card.Small -> (holder as? CardSmallHolder)?.bind(item, callback)
            is TestItem.Card.Medium -> (holder as? CardMediumHolder)?.bind(item, callback)
            is TestItem.Card.Big -> (holder as? CardBigHolder)?.bind(item, callback)
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        (holder as? UnbindCallback)?.unbind()
    }

    override fun getItemViewType(position: Int): Int = list[position].type

    interface Callback : HeaderHolder.Callback,
        ButtonHolder.Callback,
            CardSmallHolder.Callback,
            CardMediumHolder.Callback,
            CardBigHolder.Callback

}