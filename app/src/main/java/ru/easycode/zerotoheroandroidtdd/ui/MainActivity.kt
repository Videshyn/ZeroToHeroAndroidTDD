package ru.easycode.zerotoheroandroidtdd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import ru.easycode.zerotoheroandroidtdd.data.LiveDataWrapperImpl
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.data.repository.RepositoryImpl

class MainActivity : AppCompatActivity() {

    private val liveDataWrapper = LiveDataWrapperImpl()
    private val viewModel by lazy {
        MainViewModel(
            liveDataWrapper = liveDataWrapper,
            repository = RepositoryImpl()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.actionButton)
        val tv = findViewById<TextView>(R.id.titleTextView)
        val pb = findViewById<ProgressBar>(R.id.progressBar)

        liveDataWrapper.liveData().observe(this) { uiState ->
            pb.isVisible = uiState is UiState.ShowProgress
            btn.isEnabled = uiState is UiState.ShowData
            tv.isVisible = uiState is UiState.ShowData
        }

        btn.setOnClickListener { viewModel.load() }
    }
}