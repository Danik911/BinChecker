package com.example.binchecker.domain.use_cases

import com.example.binchecker.data.repository.Repository
import com.example.binchecker.domain.model.Bank
import timber.log.Timber
import javax.inject.Inject

class DeleteBankUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(bank: Bank) {
        return repository.deleteBank(bank = bank)
    }
}