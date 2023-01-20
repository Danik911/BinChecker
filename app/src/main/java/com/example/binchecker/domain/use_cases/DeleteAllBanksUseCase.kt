package com.example.binchecker.domain.use_cases

import com.example.binchecker.data.repository.Repository
import timber.log.Timber
import javax.inject.Inject

class DeleteAllBanksUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() {
        return repository.deleteAllBanks()
    }
}