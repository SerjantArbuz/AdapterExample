package sgtmelon.adapterexample.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.SimpleAdapter
import sgtmelon.adapterexample.model.Item
import sgtmelon.adapterexample.provider.SimpleListProvider
import sgtmelon.adapterexample.showToast

/**
 * Screen with demonstration of multiple column grid and different items
 * in one single [SimpleAdapter].
 */
class SimpleActivity : AppCompatActivity(), SimpleAdapter.Callback {

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.simple_recycler) }

    private val listProvider = SimpleListProvider()
    private val adapter = SimpleAdapter(callback = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        setupRecycler()
        updateList()
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

    private fun updateList() = adapter.setList(listProvider.get()).notifyDataSetChanged()

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

    companion object {
        operator fun get(context: Context): Intent = Intent(context, SimpleActivity::class.java)
    }
}