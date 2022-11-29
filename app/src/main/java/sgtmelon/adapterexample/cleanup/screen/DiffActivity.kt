package sgtmelon.adapterexample.cleanup.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.cleanup.adapter.DiffAdapter
import sgtmelon.adapterexample.cleanup.provider.DiffListProvider
import sgtmelon.adapterexample.model.Item
import sgtmelon.adapterexample.runMain
import sgtmelon.adapterexample.showToast

/**
 * Screen almost like [SimpleActivity], but with diff adapter ([DiffAdapter]).
 */
class DiffActivity : AppCompatActivity(), DiffAdapter.Callback {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.diff_recycler) }

    private val listProvider = DiffListProvider
    private val adapter = DiffAdapter(callback = this)

    private val job by lazy { Job() }
    private val uiScope by lazy { CoroutineScope(context = Dispatchers.Main + job) }
    private val ioScope by lazy { CoroutineScope(context = Dispatchers.IO + job) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)

        setupRecycler()

        updateList(listProvider.get())

        /**
         * Delay is used for item images normal load.
         */
        ioScope.launch {
            delay(timeMillis = 35000)
            runMain { startUpdateList() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun setupRecycler() {
        val spanCount = 6

        /**
         * Variables for better understanding. SpanCount must be evenly divisible on ColumnCount.
         * For example if you need 1, 2, 3 and 4 columns -> spanCount will be = 12.
         */
        val oneColumn = spanCount / 1
        val twoColumns = spanCount / 2
        val threeColumns = spanCount / 3

        val layoutManager = GridLayoutManager(this, spanCount)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemList().getOrNull(position)) {
                    is Item.Header -> oneColumn
                    is Item.Space -> oneColumn
                    is Item.Button -> threeColumns
                    is Item.Card.Small -> oneColumn
                    is Item.Card.Medium -> threeColumns
                    is Item.Card.Big -> twoColumns
                    null -> oneColumn
                }
            }
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun startUpdateList() {
        updateList(listProvider.get())

        ioScope.launch {
            delay(timeMillis = 5000)
            runMain { startUpdateList() }
        }
    }

    private fun updateList(list: List<Item>) = adapter.notifyList(list)

    //region Adapter callback's

    override fun onHeaderActionClick(item: Item.Header) {
        showToast(text = "Click on header action: $item")
    }

    override fun onButtonClick(item: Item.Button) {
        showToast(text = "Click on button: $item")
    }

    override fun onItemClick(item: Item.Card.Small) {
        showToast(text = "Click on small card: ${item.title}")
    }

    override fun onItemClick(item: Item.Card.Medium) {
        showToast(text = "Click on medium card: ${item.title}")
    }

    override fun onItemClick(item: Item.Card.Big) {
        showToast(text = "Click on big card")
    }

    //endregion

}