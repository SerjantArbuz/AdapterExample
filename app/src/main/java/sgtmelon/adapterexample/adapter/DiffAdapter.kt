package sgtmelon.adapterexample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.diff.TestDiff
import sgtmelon.adapterexample.adapter.holder.*
import sgtmelon.adapterexample.clearAdd
import sgtmelon.adapterexample.inflate
import sgtmelon.adapterexample.model.Item
import sgtmelon.adapterexample.model.ItemType
import sgtmelon.adapterexample.screen.DiffActivity

/**
 * Adapter for [DiffActivity].
 *
 * Content of this class almost the same as [SimpleAdapter] class. Difference between them in
 * [diff] thing here and in code inside parent class (under the hood).
 */
class DiffAdapter(
    private val callback: Callback
) : ParentDiffAdapter<Item, TestDiff, RecyclerView.ViewHolder>() {

    override val diff = TestDiff()

    override fun setList(list: List<Item>) = apply {
        super.setList(list)

        this.list.clearAdd(ArrayList(list.map {
            return@map when (it) {
                is Item.Card.Small -> it.copy()
                is Item.Card.Medium -> it.copy()
                is Item.Card.Big -> it.copy()
                else -> it
            }
        }))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ItemType.values()[viewType]) {
            ItemType.HEADER -> HeaderHolder(parent.inflate(R.layout.item_header))
            ItemType.SPACE -> SpaceHolder(parent.inflate(R.layout.item_space))
            ItemType.BUTTON -> ButtonHolder(parent.inflate(R.layout.item_button))
            ItemType.ITEM_SMALL -> SmallItemHolder(parent.inflate(R.layout.item_small))
            ItemType.ITEM_MEDIUM -> MediumItemHolder(parent.inflate(R.layout.item_medium))
            ItemType.ITEM_BIG -> BigItemHolder(parent.inflate(R.layout.item_big))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = list.getOrNull(position)) {
            is Item.Header -> (holder as? HeaderHolder)?.bind(item, callback)
            is Item.Space -> (holder as? SpaceHolder)?.bind(item)
            is Item.Button -> (holder as? ButtonHolder)?.bind(item, callback)
            is Item.Card.Small -> (holder as? SmallItemHolder)?.bind(item, callback)
            is Item.Card.Medium -> (holder as? MediumItemHolder)?.bind(item, callback)
            is Item.Card.Big -> (holder as? BigItemHolder)?.bind(item, callback)
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