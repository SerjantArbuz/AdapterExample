package sgtmelon.adapterexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Inflater for viewHolder.
 */
fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoof: Boolean = false): View = let {
    LayoutInflater.from(context).inflate(layout, it, attachToRoof)
}