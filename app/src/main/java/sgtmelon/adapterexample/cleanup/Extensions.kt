package sgtmelon.adapterexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import java.util.UUID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

/**
 * Help function for create unique string.
 */
fun nextString() = UUID.randomUUID().toString().substring(0, 16)

//region Coroutines

suspend inline fun <T> runBack(crossinline func: suspend () -> T): T {
    return withContext(Dispatchers.IO) { func() }
}

suspend inline fun <T> runMain(crossinline func: suspend () -> T): T {
    return withContext(Dispatchers.Main) { func() }
}

//endregion