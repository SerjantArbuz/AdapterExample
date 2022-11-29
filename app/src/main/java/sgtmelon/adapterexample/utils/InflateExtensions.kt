package sgtmelon.adapterexample.utils

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

val Context.inflater: LayoutInflater get() = LayoutInflater.from(this)

fun <T : ViewDataBinding> Activity.inflateBinding(@LayoutRes layoutId: Int): T {
    return DataBindingUtil.setContentView(this, layoutId)
}

fun <T : ViewDataBinding> ViewGroup.inflateBinding(
    @LayoutRes layoutId: Int,
    attachToParent: Boolean = false
): T {
    return DataBindingUtil.inflate(context.inflater, layoutId, this, attachToParent)
}