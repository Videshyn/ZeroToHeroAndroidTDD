package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val viewModel = VmFabric.getOrInitVm()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.actionButton)
        val tv = findViewById<TextView>(R.id.titleTextView)
        val pb = findViewById<ProgressBar>(R.id.progressBar)

        viewModel.liveData().observe(this) { uiState ->
            uiState.applyChanges(btn, tv, pb)
        }

        btn.setOnClickListener { viewModel.load() }
    }
}