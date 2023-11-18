package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter: Count = Count.Base(step = 2, max = 4, min = 0)
    private lateinit var uiState: UiState
    private lateinit var btnIncrement: Button
    private lateinit var btnDecrement: Button
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIncrement = findViewById(R.id.incrementButton)
        btnDecrement = findViewById(R.id.decrementButton)
        tvCounter = findViewById(R.id.countTextView)

        if (savedInstanceState == null) {
            // first run
            uiState = counter.initial(tvCounter.text.toString())
            uiState.apply(tvCounter, btnIncrement, btnDecrement)
        }

        btnIncrement.setOnClickListener {
            uiState = counter.increment(tvCounter.text.toString())
            uiState.apply(tvCounter, btnIncrement, btnDecrement)
        }

        btnDecrement.setOnClickListener {
            uiState = counter.decrement(tvCounter.text.toString())
            uiState.apply(tvCounter, btnIncrement, btnDecrement)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // restore state after re-creation
        uiState = counter.initial(tvCounter.text.toString())
        uiState.apply(tvCounter, btnIncrement, btnDecrement)
    }
}