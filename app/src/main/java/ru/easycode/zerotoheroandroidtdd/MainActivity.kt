package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.countTextView)
        btn = findViewById(R.id.incrementButton)

        savedInstanceState?.let { counter = it.getInt(KEY, 0) }
        setupCounter()

        btn.setOnClickListener {
            counter += 2
            setupCounter()
        }
    }

    private fun setupCounter() {
        tv.text = counter.toString()
        btn.isEnabled = counter < 4
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, counter)
    }

    companion object {
        private const val KEY = "counter_key"
    }
}