package sgtmelon.adapterexample.adapter

import android.view.ViewGroup
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.parent.ParentAdapter
import sgtmelon.adapterexample.model.MenuItem
import sgtmelon.adapterexample.utils.inflateBinding

class MenuAdapter(
    private val callback: Callback
) : ParentAdapter<MenuItem, MenuHolder>(MenuDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        return MenuHolder(parent.inflateBinding(R.layout.item_menu))
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    interface Callback : MenuHolder.Callback
}