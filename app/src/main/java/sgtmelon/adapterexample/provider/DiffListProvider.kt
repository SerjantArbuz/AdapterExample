package sgtmelon.adapterexample.provider

import sgtmelon.adapterexample.model.TestItem

/**
 * Help class for provide screen list. It's created just for example project.
 */
object DiffListProvider {

    private var needShowDiff: Boolean = false

    fun get(): List<TestItem> {
        val list = mutableListOf<TestItem>()

        if (needShowDiff) {
            list.addAll(BaseListProvider.getButtonSection())
            list.addAll(changeSmallItemSection())
            list.addAll(BaseListProvider.getMediumItemSection())
            list.addAll(BaseListProvider.getBigItemSection())
        } else {
            list.addAll(SimpleListProvider().get())
        }

        needShowDiff = !needShowDiff

        return list
    }

    /**
     * Remove some items from list
     */
    private fun changeSmallItemSection(): List<TestItem> {
        val list = BaseListProvider.getSmallItemSection()

        for (i in 0 until (1..3).random()) {
            val item = list.filterIsInstance<TestItem.Item.Small>().random()
            val index = list.indexOf(item).takeIf { it != -1 } ?: continue
            list.removeAt(index)
        }

        return list
    }

}