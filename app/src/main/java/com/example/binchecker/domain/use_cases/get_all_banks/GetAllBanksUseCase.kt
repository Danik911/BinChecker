package com.example.binchecker.domain.use_cases.get_all_banks

import com.example.binchecker.data.repository.Repository
import com.example.binchecker.domain.model.Bank
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class GetAllBanksUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): Flow<List<Bank>> {
        Timber.d("GetAllBanks called")
        return repository.getAllBanks()
    }
}