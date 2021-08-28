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
            list.addAll(changeMediumItemSection())
            list.addAll(changeBigItemSection())
        } else {
            list.addAll(SimpleListProvider().get())
        }

        needShowDiff = !needShowDiff

        return list
    }

    private fun changeSmallItemSection(): List<TestItem> {
        /**
         * Copy list for prevent overriding cache inside [BaseListProvider].
         */
        val list = ArrayList(BaseListProvider.getSmallItemSection())

        for (i in 0 until (1..2).random()) {
            val item = list.filterIsInstance<TestItem.Item.Small>().random()
            val index = list.indexOf(item).takeIf { it != -1 } ?: continue
            list.removeAt(index)
        }

        return list
    }

    private fun changeMediumItemSection(): List<TestItem> {
        /**
         * Copy list for prevent overriding cache inside [BaseListProvider].
         */
        val list = ArrayList(BaseListProvider.getMediumItemSection().map {
            if (it is TestItem.Item.Medium) it.copy() else it
        })

        val item = list.filterIsInstance<TestItem.Item.Medium>().random()
        item.imageUrl = "https://images.unsplash.com/photo-1629995235051-069c3e984598"
        item.title = "Here we are!"
        item.subtitle = "Item updated"

        return list
    }

    private fun changeBigItemSection(): List<TestItem> {
        /**
         * Copy list for prevent overriding cache inside [BaseListProvider].
         */
        val originalList = ArrayList(BaseListProvider.getBigItemSection())

        val returnList = mutableListOf<TestItem>()
        returnList.addAll(originalList.filterNot { it is TestItem.Item.Big })
        returnList.addAll(originalList.filterIsInstance<TestItem.Item.Big>().shuffled())

        return returnList
    }
}