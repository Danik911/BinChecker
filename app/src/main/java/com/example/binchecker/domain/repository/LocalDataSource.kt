package com.example.binchecker.domain.repository

import com.example.binchecker.domain.model.Bank
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getBank(): Bank
    fun readAllBanks(): Flow<List<Bank>>
    suspend fun insertBank(bank: Bank)
    suspend fun deleteAllBanks()
}