package com.example.binchecker.domain.use_cases

import com.example.binchecker.data.repository.Repository
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class GetAllBanksUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<List<Bank>> {
        return repository.getAllBanks()
    }
}