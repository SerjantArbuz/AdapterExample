package sgtmelon.adapterexample.cleanup.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.cleanup.adapter.holder.BigItemHolder
import sgtmelon.adapterexample.cleanup.adapter.holder.ButtonHolder
import sgtmelon.adapterexample.cleanup.adapter.holder.HeaderHolder
import sgtmelon.adapterexample.cleanup.adapter.holder.MediumItemHolder
import sgtmelon.adapterexample.cleanup.adapter.holder.SmallItemHolder
import sgtmelon.adapterexample.cleanup.adapter.holder.SpaceHolder
import sgtmelon.adapterexample.cleanup.adapter.holder.UnbindCallback
import sgtmelon.adapterexample.cleanup.screen.SimpleActivity
import sgtmelon.adapterexample.inflate
import sgtmelon.adapterexample.model.Item
import sgtmelon.adapterexample.model.ItemType

/**
 * Adapter for [SimpleActivity].
 */
class SimpleAdapter(
    private val callback: Callback
) : ParentAdapter<Item, RecyclerView.ViewHolder>() {

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
        when (val item = list.getOrNull(position) ?: return) {
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