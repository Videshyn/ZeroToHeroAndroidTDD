package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.removeButton)
        val tv = findViewById<TextView>(R.id.titleTextView)
        val root = findViewById<LinearLayout>(R.id.rootLayout)

        savedInstanceState?.let {
            if (it.getBoolean(KEY, false)) {
                removeViewAndDisableButton(btn, root, tv)
            }
        }

        btn.setOnClickListener {
            removeViewAndDisableButton(btn, root, tv)
        }
    }

    private fun removeViewAndDisableButton(btn: Button, root: LinearLayout, tv: TextView) {
        btn.isEnabled = false
        root.removeView(tv)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY, !btn.isEnabled)
    }

    companion object {
        private const val KEY = "SHOULD_DISABLE"
    }
}