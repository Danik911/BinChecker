package com.example.binchecker.data.repository

import com.example.binchecker.data.local.BankDatabase
import com.example.binchecker.data.remote.BinApi
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val binApi: BinApi,
    private val bankDatabase: BankDatabase
) : RemoteDataSource {
    override suspend fun getBank(): Bank {
        TODO("Not yet implemented")
    }

    override fun getAllBanks(): Flow<List<Bank>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun insertBank(bank: Bank) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllBanks() {
        TODO("Not yet implemented")
    }

    override suspend fun getApiResponse(bin: String): ApiResponse {
        return binApi.getBankInfo(bin = bin)

    }
}