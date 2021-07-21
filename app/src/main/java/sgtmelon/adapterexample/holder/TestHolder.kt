package sgtmelon.adapterexample.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import sgtmelon.adapterexample.TestAdapter

/**
 * Sealed class of holders for [TestAdapter].
 */
sealed class TestHolder(itemView: View) : RecyclerView.ViewHolder(itemView)