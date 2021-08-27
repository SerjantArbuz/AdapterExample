package sgtmelon.adapterexample.provider

import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.nextString

/**
 * Help class for provide screen list. It's created just for example project.
 */
object BaseListProvider {

    /**
     * Cache our lists for stable [TestItem.id].
     */
    private var buttonSectionList: MutableList<TestItem>? = null
    private var smallItemSectionList: MutableList<TestItem>? = null
    private var mediumItemSectionList: MutableList<TestItem>? = null
    private var bigItemSectionList: MutableList<TestItem>? = null

    fun getButtonSection(): MutableList<TestItem> = buttonSectionList ?: run {
        val list = mutableListOf<TestItem>()

        val imageList = listOf(
            "https://images.unsplash.com/photo-1501630834273-4b5604d2ee31",
            "https://images.unsplash.com/photo-1429734956993-8a9b0555e122",
            "https://images.unsplash.com/photo-1599940824399-b87987ceb72a",
            "https://images.unsplash.com/photo-1599148401005-fe6d7497cb5e",
            "https://images.unsplash.com/photo-1551478578-633e748b8822",
            "https://images.unsplash.com/photo-1498330177096-689e3fb901ca"
        )

        list.add(TestItem.Header.First)
        list.add(TestItem.Space.Medium)
        list.add(TestItem.Button.First(imageList[0]))
        list.add(TestItem.Button.Second(imageList[1]))
        list.add(TestItem.Button.Third(imageList[2]))
        list.add(TestItem.Space.Small)
        list.add(TestItem.Button.Fourth(imageList[3]))
        list.add(TestItem.Button.Fifth(imageList[4]))
        list.add(TestItem.Button.Sixth(imageList[5]))

        buttonSectionList = list

        return@run list
    }

    fun getSmallItemSection(): MutableList<TestItem> = smallItemSectionList ?: run {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Space.Big)
        list.add(TestItem.Header.Second)
        list.add(TestItem.Space.Small)

        val imageList = listOf(
            "https://images.unsplash.com/photo-1442458017215-285b83f65851",
            "https://images.unsplash.com/photo-1495231916356-a86217efff12",
            "https://images.unsplash.com/photo-1516205651411-aef33a44f7c2",
            "https://images.unsplash.com/photo-1496483648148-47c686dc86a8"
        )
        val longText = "long long long long"
        repeat(imageList.size) {
            list.add(TestItem.Item.Small(
                nextString(),
                imageList[it],
                title = "Small $longText title: $it",
                subtitle = "Small $longText subtitle: $it"
            ))
        }

        smallItemSectionList = list

        return@run list
    }

    fun getMediumItemSection(): MutableList<TestItem> = mediumItemSectionList ?: run {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Space.Big)
        list.add(TestItem.Header.Third)
        list.add(TestItem.Space.Small)

        val imageList = listOf(
            "https://images.unsplash.com/photo-1552483777-6d0e5cc7e09f",
            "https://images.unsplash.com/photo-1541410813355-b423ffce2a22",
            "https://images.unsplash.com/photo-1597271479291-265397b445c9"
        )

        repeat(imageList.size) {
            list.add(TestItem.Item.Medium(
                nextString(),
                imageList[it],
                title = "Medium title: $it",
                subtitle = "Medium subtitle: $it"
            ))
        }

        mediumItemSectionList = list

        return@run list
    }

    fun getBigItemSection(): MutableList<TestItem> = bigItemSectionList ?: run {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Space.Big)
        list.add(TestItem.Header.Fourth)
        list.add(TestItem.Space.Medium)

        val imageList = listOf(
            "https://images.unsplash.com/photo-1439405326854-014607f694d7",
            "https://images.unsplash.com/photo-1527482797697-8795b05a13fe",
            "https://images.unsplash.com/photo-1500674425229-f692875b0ab7",
            "https://images.unsplash.com/photo-1518084132696-ae8c27911102"
        )

        repeat(imageList.size) {
            list.add(TestItem.Item.Big(nextString(), imageList[it]))
        }

        bigItemSectionList = list

        return@run list
    }

}