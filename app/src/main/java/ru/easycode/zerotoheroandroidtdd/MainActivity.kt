package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter: Count = Count.Base(step = 2, max = 4)
    private var uiState: UiState = UiState.Base(text = "0")

    private lateinit var btn: Button
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.countTextView)
        btn = findViewById(R.id.incrementButton)

        btn.setOnClickListener {
            uiState = counter.increment(tv.text.toString())
            uiState.apply(tv, btn)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(STATE_KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(STATE_KEY) as UiState
        uiState.apply(tv, btn)
    }

    companion object {
        private const val STATE_KEY = "state_key"
    }
}