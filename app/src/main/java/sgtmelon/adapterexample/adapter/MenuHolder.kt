package sgtmelon.adapterexample.adapter

import sgtmelon.adapterexample.adapter.parent.ParentHolder
import sgtmelon.adapterexample.databinding.ItemMenuBinding
import sgtmelon.adapterexample.model.MenuItem

class MenuHolder(
    private val binding: ItemMenuBinding
) : ParentHolder(binding) {

    fun bind(item: MenuItem, callback: Callback) = with(binding) {
        button.text = context.getString(item.textId)
        button.setOnClickListener { callback.onMenuClick(item) }
    }

    override fun unbind() {
        binding.button.setOnClickListener(null)
    }

    interface Callback {
        fun onMenuClick(item: MenuItem)
    }
}