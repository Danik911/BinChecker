package com.example.binchecker.data.repository

import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.LocalDataSource
import com.example.binchecker.domain.repository.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) {


    fun getAllBanks(): Flow<List<Bank>> {
        return localDataSource.getAllBanks()
    }

     suspend fun getApiResponse(bin: String) = withContext(Dispatchers.IO) {
         return@withContext remoteDataSource.getApiResponse(bin = bin)
    }

     suspend fun deleteAllBanks() = withContext(Dispatchers.IO) {
        localDataSource.deleteAllBanks()
    }


    suspend fun deleteBank(bank: Bank) = withContext(Dispatchers.IO) {
        localDataSource.deleteBank(bank = bank)
    }

}