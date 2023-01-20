package com.example.binchecker.data.repository

import com.example.binchecker.data.remote.BinApi
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.LocalDataSource
import com.example.binchecker.domain.repository.RemoteDataSource
import timber.log.Timber

class RemoteDataSourceImpl(
    private val binApi: BinApi,
    private val localDataSource: LocalDataSource
) : RemoteDataSource {

     override suspend fun getApiResponse(bin: String): ApiResponse {
       return try {
            val response = binApi.getBankInfo(bin = bin)
            localDataSource.insertBank(response)
           response.copy(success = true)

        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }
}