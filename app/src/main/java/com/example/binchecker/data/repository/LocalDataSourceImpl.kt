package com.example.binchecker.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.binchecker.data.local.BankDatabase
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(bankDatabase: BankDatabase) : LocalDataSource {

    private val bankDao = bankDatabase.bankDao()
    override suspend fun getBank(): Bank {
        TODO("Not yet implemented")
    }

    override fun readAllBanks(): Flow<List<Bank>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBank(bank: Bank) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllBanks() {
        TODO("Not yet implemented")
    }


}