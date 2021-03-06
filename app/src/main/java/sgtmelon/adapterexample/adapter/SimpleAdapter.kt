package sgtmelon.adapterexample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.holder.*
import sgtmelon.adapterexample.inflate
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.model.TestType
import sgtmelon.adapterexample.screen.SimpleActivity

/**
 * Adapter for [SimpleActivity].
 */
class SimpleAdapter(
    private val callback: Callback
) : ParentAdapter<TestItem, RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (TestType.values()[viewType]) {
            TestType.HEADER -> HeaderHolder(parent.inflate(R.layout.item_header))
            TestType.SPACE -> SpaceHolder(parent.inflate(R.layout.item_space))
            TestType.BUTTON -> ButtonHolder(parent.inflate(R.layout.item_button))
            TestType.ITEM_SMALL -> SmallItemHolder(parent.inflate(R.layout.item_small))
            TestType.ITEM_MEDIUM -> MediumItemHolder(parent.inflate(R.layout.item_medium))
            TestType.ITEM_BIG -> BigItemHolder(parent.inflate(R.layout.item_big))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = list.getOrNull(position)) {
            is TestItem.Header -> (holder as? HeaderHolder)?.bind(item, callback)
            is TestItem.Space -> (holder as? SpaceHolder)?.bind(item)
            is TestItem.Button -> (holder as? ButtonHolder)?.bind(item, callback)
            is TestItem.Item.Small -> (holder as? SmallItemHolder)?.bind(item, callback)
            is TestItem.Item.Medium -> (holder as? MediumItemHolder)?.bind(item, callback)
            is TestItem.Item.Big -> (holder as? BigItemHolder)?.bind(item, callback)
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        (holder as? UnbindCallback)?.unbind()
    }

    override fun getItemViewType(position: Int): Int = list[position].type.ordinal

    interface Callback : HeaderHolder.Callback,
        ButtonHolder.Callback,
            SmallItemHolder.Callback,
            MediumItemHolder.Callback,
            BigItemHolder.Callback
}