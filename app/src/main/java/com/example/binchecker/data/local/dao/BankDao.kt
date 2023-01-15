package com.example.binchecker.data.local.dao

import androidx.room.*
import com.example.binchecker.domain.model.Bank
import kotlinx.coroutines.flow.Flow

@Dao
interface BankDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBank(bank: Bank)

    @Query("SELECT * FROM bank_table ORDER BY id ASC")
    fun readAllBanks(): Flow<List<Bank>>

    @Query("SELECT * FROM bank_table ORDER BY id ASC LIMIT 1")
    suspend fun readBank(): Bank

    @Query("DELETE FROM bank_table")
    suspend fun deleteAllBanks()

}