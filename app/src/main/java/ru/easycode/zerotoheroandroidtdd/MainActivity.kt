package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.titleTextView)
        val pb = findViewById<ProgressBar>(R.id.progressBar)
        val btn = findViewById<Button>(R.id.actionButton)

        btn.setOnClickListener {
            btn.isEnabled = false
            pb.isVisible = true

            handler.postDelayed({
                btn.isEnabled = true
                pb.isVisible = false
                tv.isVisible = true
            }, 3500)
        }
    }

    override fun onPause() {
        handler.removeCallbacksAndMessages(null)
        super.onPause()
    }
}