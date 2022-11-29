package sgtmelon.adapterexample.screen

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import sgtmelon.adapterexample.utils.inflateBinding

abstract class BindingActivity<T : ViewDataBinding> : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutId: Int

    private var _binding: T? = null
    protected val binding: T? get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding(layoutId)

        setupView()
        setupObservers()
    }

    open fun setupView() = Unit

    open fun setupObservers() = Unit

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}