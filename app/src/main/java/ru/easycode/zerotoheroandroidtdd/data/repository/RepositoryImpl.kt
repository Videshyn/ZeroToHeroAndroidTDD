package ru.easycode.zerotoheroandroidtdd.data.repository

import kotlinx.coroutines.delay
import ru.easycode.zerotoheroandroidtdd.domain.repository.Repository

class RepositoryImpl: Repository {
    override suspend fun load() {
        delay(2000)
    }
}