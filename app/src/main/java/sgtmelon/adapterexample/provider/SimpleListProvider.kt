package sgtmelon.adapterexample.provider

import sgtmelon.adapterexample.model.Item

/**
 * Help class for provide screen list. It's created just for example project.
 */
class SimpleListProvider {

    fun get(): List<Item> {
        val list = mutableListOf<Item>()

        list.addAll(BaseListProvider.getButtonSection())
        list.addAll(BaseListProvider.getSmallItemSection())
        list.addAll(BaseListProvider.getMediumItemSection())
        list.addAll(BaseListProvider.getBigItemSection())

        return list
    }
}