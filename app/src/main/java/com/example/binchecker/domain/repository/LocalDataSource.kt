package com.example.binchecker.domain.repository

import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAllBanks(): Flow<List<Bank>>
    suspend fun insertBank(apiResponse: ApiResponse)
    suspend fun deleteAllBanks()
    suspend fun deleteBank(bank: Bank)
}