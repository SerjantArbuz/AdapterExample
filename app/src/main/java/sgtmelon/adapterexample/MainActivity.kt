package sgtmelon.adapterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun updateList() {
        val list = mutableListOf<TestItem>()

        list.add(TestItem.Header.First)
        list.add(TestItem.Space.Small)
        list.add(TestItem.Button.First)

        list.add(TestItem.Space.Medium)
        list.add(TestItem.Header.Second)
        list.add(TestItem.Space.Small)
        list.add(TestItem.Button.Second)

        list.add(TestItem.Space.Medium)
        list.add(TestItem.Header.Third)
        list.add(TestItem.Space.Small)
        list.add(TestItem.Button.Third)

        list.add(TestItem.Space.Medium)
        list.add(TestItem.Header.Fourth)
        list.add(TestItem.Space.Small)
        list.add(TestItem.Button.Fourth)

        adapter.setList(list).notifyDataSetChanged()
    }

    //region Adapter callback's

    override fun onHeaderActionClick(item: TestItem.Header) {
        showToast(text = "Click on header action: $item")
    }

    override fun onButtonClick(item: TestItem.Button) {
        showToast(text = "Click on button: $item")
    }

    override fun onCardClick(item: TestItem.Card.Small) {
        showToast(text = "Click on small card: ${item.title}")
    }

    override fun onCardClick(item: TestItem.Card.Medium) {
        showToast(text = "Click on medium card: ${item.title}")
    }

    override fun onCardClick(item: TestItem.Card.Big) {
        showToast(text = "Click on big card")
    }

    //endregion

}