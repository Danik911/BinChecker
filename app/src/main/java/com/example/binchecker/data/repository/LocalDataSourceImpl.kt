package com.example.binchecker.data.repository

import com.example.binchecker.data.local.BankDatabase
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class LocalDataSourceImpl(bankDatabase: BankDatabase) : LocalDataSource {

    private val bankDao = bankDatabase.bankDao()

    override fun getAllBanks(): Flow<List<Bank>> {
       return bankDao.readAllBanks()
    }

    override suspend fun insertBank(apiResponse: ApiResponse) {
        if (apiResponse.bank != null){
             bankDao.insertBank(apiResponse.bank)
            Timber.tag("LocalDataSours $apiResponse")
        }else{
            throw Exception()
        }
    }


    override suspend fun deleteAllBanks() {
        TODO("Not yet implemented")
    }




}