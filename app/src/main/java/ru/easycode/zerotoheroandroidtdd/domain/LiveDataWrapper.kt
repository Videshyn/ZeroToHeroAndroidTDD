package ru.easycode.zerotoheroandroidtdd.domain

import androidx.lifecycle.LiveData
import ru.easycode.zerotoheroandroidtdd.ui.UiState

interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>
}