package sgtmelon.adapterexample.cleanup.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import sgtmelon.adapterexample.R

/**
 * Screen for display main menu, where we can choose which screen with example to open.
 */
class MenuActivity : AppCompatActivity(), View.OnClickListener {

    private val simpleButton by lazy { findViewById<View>(R.id.menu_simple_button) }
    private val diffButton by lazy { findViewById<View>(R.id.menu_diff_button) }

    private val buttonList by lazy { listOf(simpleButton, diffButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        for (button in buttonList) {
            button.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) = when (view) {
        simpleButton -> startActivity(SimpleActivity[this])
        diffButton -> startActivity(DiffActivity[this])
        else -> Unit
    }
}