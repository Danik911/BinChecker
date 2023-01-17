package com.example.binchecker.data.repository

import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.LocalDataSource
import com.example.binchecker.domain.repository.RemoteDataSource
import com.example.binchecker.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) {

    fun getAllBanks(): Flow<List<Bank>> {
        return remoteDataSource.getAllBanks()
    }

     suspend fun getApiResponse(): Resource<ApiResponse> {
        return  remoteDataSource.getApiResponse()
    }

}