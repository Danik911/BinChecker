package com.example.binchecker.domain.repository

import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.util.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getBank(): Bank
    fun getAllBanks(): Flow<List<Bank>>
    suspend fun insertBank(bank: Bank)
    suspend fun deleteAllBanks()
    suspend fun getApiResponse(): Resource<ApiResponse>
}