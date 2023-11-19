package ru.easycode.zerotoheroandroidtdd.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.easycode.zerotoheroandroidtdd.ui.UiState
import ru.easycode.zerotoheroandroidtdd.domain.LiveDataWrapper

class LiveDataWrapperImpl: LiveDataWrapper {

    private val liveData = MutableLiveData<UiState>()

    override fun update(value: UiState) {
        liveData.postValue(value)
    }

    override fun liveData(): LiveData<UiState> {
        return liveData
    }
}