package sgtmelon.adapterexample.provider

import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.nextString

/**
 * Help class for provide screen list. It's created just for example project.
 */
class SimpleListProvider {

    fun get(): List<TestItem> {
        val list = mutableListOf<TestItem>()

        list.addAll(BaseListProvider.getButtonSection())
        list.addAll(BaseListProvider.getSmallItemSection())
        list.addAll(BaseListProvider.getMediumItemSection())
        list.addAll(BaseListProvider.getBigItemSection())

        return list
    }
}