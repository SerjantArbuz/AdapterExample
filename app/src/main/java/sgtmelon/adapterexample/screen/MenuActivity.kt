package sgtmelon.adapterexample.screen

import android.content.Intent
import sgtmelon.adapterexample.R
import sgtmelon.adapterexample.adapter.MenuAdapter
import sgtmelon.adapterexample.cleanup.screen.DiffActivity
import sgtmelon.adapterexample.cleanup.screen.SimpleActivity
import sgtmelon.adapterexample.databinding.ActivityMenuBinding
import sgtmelon.adapterexample.model.MenuItem

/**
 * Screen for display main menu, where we can choose which screen with example to open.
 */
class MenuActivity : BindingActivity<ActivityMenuBinding>(),
    MenuAdapter.Callback {

    override val layoutId: Int = R.layout.activity_menu

    override fun setupView() {
        super.setupView()

        val adapter = MenuAdapter(callback = this)
        binding?.menuRecycler?.also {
            it.setHasFixedSize(true)
            it.adapter = adapter
        }
        adapter.submitList(getMenuList())
    }

    private fun getMenuList(): List<MenuItem> {
        return listOf(
            MenuItem(id = 0, R.string.menu_simple, SimpleActivity::class.java),
            MenuItem(id = 1, R.string.menu_diff, DiffActivity::class.java)
        )
    }

    override fun onMenuClick(item: MenuItem) {
        startActivity(Intent(this, item.classLink))
    }
}