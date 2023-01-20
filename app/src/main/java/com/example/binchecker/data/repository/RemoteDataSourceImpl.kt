package com.example.binchecker.data.repository

import com.example.binchecker.data.remote.BinApi
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.LocalDataSource
import com.example.binchecker.domain.repository.RemoteDataSource

class RemoteDataSourceImpl(
    private val binApi: BinApi,
    private val localDataSource: LocalDataSource
) : RemoteDataSource {


    override suspend fun getBank(): Bank {
        TODO("Not yet implemented")
    }


    override suspend fun insertBank(bank: Bank) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllBanks() {
        TODO("Not yet implemented")
    }

    override suspend fun getApiResponse(bin: String): ApiResponse {
        var response = ApiResponse(success = false)
        try {
            response = binApi.getBankInfo(bin = bin)
            localDataSource.insertBank(response)

        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
        return response
    }
}