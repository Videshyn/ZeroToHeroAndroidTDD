package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.countTextView)
        val btn = findViewById<Button>(R.id.incrementButton)

        savedInstanceState?.let { counter = it.getInt(KEY, 0) }
        tv.text = counter.toString()

        btn.setOnClickListener {
            counter += 2
            tv.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, counter)
    }

    companion object {
        private const val KEY = "counter_key"
    }
}