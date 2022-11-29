package sgtmelon.adapterexample.adapter

import androidx.recyclerview.widget.DiffUtil
import sgtmelon.adapterexample.model.MenuItem

class MenuDiff : DiffUtil.ItemCallback<MenuItem>() {

    override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem == newItem
    }
}