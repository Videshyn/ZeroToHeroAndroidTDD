package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {
    fun applyChanges(btn: Button, tv: TextView, pb: ProgressBar)

    object ShowProgress : UiState {
        override fun applyChanges(btn: Button, tv: TextView, pb: ProgressBar) {
            btn.isEnabled = false
            tv.isVisible = false
            pb.isVisible = true
        }

    }

    object ShowData : UiState {
        override fun applyChanges(btn: Button, tv: TextView, pb: ProgressBar) {
            btn.isEnabled = true
            tv.isVisible = true
            pb.isVisible = false
        }
    }
}