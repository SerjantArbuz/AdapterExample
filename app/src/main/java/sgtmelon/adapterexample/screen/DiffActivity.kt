package sgtmelon.adapterexample.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.DiffAdapter
import sgtmelon.adapterexample.model.TestItem
import sgtmelon.adapterexample.provider.DiffListProvider
import sgtmelon.adapterexample.runBack
import sgtmelon.adapterexample.showToast

/**
 * Screen almost like [SimpleActivity], but with diff adapter ([DiffAdapter]).
 */
class DiffActivity : AppCompatActivity(), DiffAdapter.Callback {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.diff_recycler) }

    private val listProvider = DiffListProvider
    private val adapter = DiffAdapter(callback = this)

    private val job by lazy { Job() }
    private val mainScope by lazy { CoroutineScope(context = Dispatchers.Main + job) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)

        setupRecycler()
        startUpdateList()
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
                    is TestItem.Header -> oneColumn
                    is TestItem.Space -> oneColumn
                    is TestItem.Button -> threeColumns
                    is TestItem.Item.Small -> oneColumn
                    is TestItem.Item.Medium -> threeColumns
                    is TestItem.Item.Big -> twoColumns
                    null -> oneColumn
                }
            }
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun startUpdateList() {
        updateList()

        mainScope.launch {
            runBack { delay(timeMillis = 5000) }
            startUpdateList()
        }
    }

    private fun updateList() = adapter.notifyList(listProvider.get())

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

    companion object {
        operator fun get(context: Context): Intent = Intent(context, DiffActivity::class.java)
    }
}