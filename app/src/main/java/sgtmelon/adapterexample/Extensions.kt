package sgtmelon.adapterexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes

/**
 * Inflater for viewHolder.
 */
fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoof: Boolean = false): View = let {
    LayoutInflater.from(context).inflate(layout, it, attachToRoof)
}

fun View.updateMargin(
    left: Int? = (layoutParams as? ViewGroup.MarginLayoutParams)?.leftMargin,
    top: Int? = (layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin,
    right: Int? = (layoutParams as? ViewGroup.MarginLayoutParams)?.rightMargin,
    bottom: Int? = (layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin
) {
    if (left == null || top == null || right == null || bottom == null) return

    val params = layoutParams as? ViewGroup.MarginLayoutParams ?: return
    params.setMargins(left, top, right, bottom)
    layoutParams = params
}

fun Context.showToast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}

fun <T> MutableList<T>.clearAdd(replace: List<T>) = apply {
    clear()
    addAll(replace)
}