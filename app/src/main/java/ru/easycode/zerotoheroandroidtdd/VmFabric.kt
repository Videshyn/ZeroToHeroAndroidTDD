package ru.easycode.zerotoheroandroidtdd

object VmFabric {

    private lateinit var instance: MainViewModel

    fun getOrInitVm(): MainViewModel {
        if (::instance.isInitialized) return instance

        instance = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
        return instance
    }
}