package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.titleTextView)
        val btn = findViewById<Button>(R.id.removeButton)
        val root = findViewById<LinearLayout>(R.id.rootLayout)

        if (savedInstanceState != null) {
            root.removeView(tv)
        }

        btn.setOnClickListener { root.removeView(tv) }
    }
}