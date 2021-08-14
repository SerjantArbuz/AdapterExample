package sgtmelon.adapterexample.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sgtmelon.adapterexample.R

class DiffActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)
    }

    companion object {
        operator fun get(context: Context): Intent = Intent(context, DiffActivity::class.java)
    }
}