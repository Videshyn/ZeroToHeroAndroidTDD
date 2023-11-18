package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var btnIncrement: Button
    private lateinit var btnDecrement: Button
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIncrement = findViewById(R.id.incrementButton)
        btnDecrement = findViewById(R.id.decrementButton)
        tvCounter = findViewById(R.id.countTextView)

        savedInstanceState?.let { counter = it.getInt(KEY, 0) }
        setupCounter()

        btnIncrement.setOnClickListener {
            counter += 2
            setupCounter()
        }

        btnDecrement.setOnClickListener {
            counter -= 2
            setupCounter()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, counter)
    }

    private fun setupCounter() {
        btnDecrement.isEnabled = counter > 0
        btnIncrement.isEnabled = counter < 4
        tvCounter.text = counter.toString()
    }

    companion object {
        private const val KEY = "counter_key"
    }
}