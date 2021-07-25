package sgtmelon.adapterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.model.TestItem

class MainActivity : AppCompatActivity(), TestAdapter.Callback {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.main_recycler) }

    private val adapter = TestAdapter(callback = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
        updateList()
    }

    private fun setupRecycler() {
        val spanCount = 6
        val layoutManager = GridLayoutManager(this, spanCount)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val item = adapter.getItemList().getOrNull(position) ?: return spanCount

                return when (item) {
                    is TestItem.Header -> spanCount
                    is TestItem.Space -> spanCount
                    is TestItem.Button -> spanCount / 3
                    is TestItem.Item.Small -> spanCount
                    is TestItem.Item.Medium -> spanCount / 3
                    is TestItem.Item.Big -> spanCount / 2
                }
            }
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun updateList() {
        val list = mutableListOf<TestItem>()

        list.addAll(getButtonSection())
        list.addAll(getSmallItemSection())
        list.addAll(getMediumItemSection())
        list.addAll(getBigItemSection())

        adapter.setList(list).notifyDataSetChanged()
    }

    private fun getButtonSection(): List<TestItem> {
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

        return list
    }

    private fun getSmallItemSection(): List<TestItem> {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Space.Big)
        list.add(TestItem.Header.Second)
        list.add(TestItem.Space.Small)

        val imageList = listOf(
            "https://images.unsplash.com/photo-1442458017215-285b83f65851",
            "https://images.unsplash.com/photo-1495231916356-a86217efff12",
            "https://images.unsplash.com/photo-1516205651411-aef33a44f7c2",
            "https://images.unsplash.com/photo-1496483648148-47c686dc86a8",
            "https://images.unsplash.com/photo-1503652601-557d07733ddc"
        )

        repeat(times = (3..5).random()) {
            list.add(TestItem.Item.Small(
                imageList[it],
                title = "Small title: $it",
                subtitle = "Small subtitle: $it"
            ))
        }

        return list
    }

    private fun getMediumItemSection(): List<TestItem> {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Space.Big)
        list.add(TestItem.Header.Third)
        list.add(TestItem.Space.Medium)

        return list
    }

    private fun getBigItemSection(): List<TestItem> {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Space.Big)
        list.add(TestItem.Header.Fourth)
        list.add(TestItem.Space.Medium)

        return list
    }

    //region Adapter callback's

    override fun onHeaderActionClick(item: TestItem.Header) {
        showToast(text = "Click on header action: $item")
    }

    override fun onButtonClick(item: TestItem.Button) {
        showToast(text = "Click on button: $item")
    }

    override fun onItemClick(item: TestItem.Item.Small) {
        showToast(text = "Click on small card: ${item.title}")
    }

    override fun onItemClick(item: TestItem.Item.Medium) {
        showToast(text = "Click on medium card: ${item.title}")
    }

    override fun onItemClick(item: TestItem.Item.Big) {
        showToast(text = "Click on big card")
    }

    //endregion

}