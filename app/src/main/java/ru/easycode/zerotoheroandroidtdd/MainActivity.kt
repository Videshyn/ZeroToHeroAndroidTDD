package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.titleTextView)
        val btn = findViewById<Button>(R.id.hideButton)

        if (savedInstanceState != null) tv.isGone = true

        btn.setOnClickListener { tv.isGone = true }
    }
}