package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter: Count = Count.Base(step = 2)
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.countTextView)
        val btn = findViewById<Button>(R.id.incrementButton)

        savedInstanceState?.let { tv.text = it.getString(KEY, "") }

        btn.setOnClickListener { tv.text = counter.increment(tv.text.toString()) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, tv.text.toString())
    }

    companion object {
        private const val KEY = "counter_key"
    }
}