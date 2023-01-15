package com.example.binchecker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.binchecker.data.local.dao.BankDao
import com.example.binchecker.domain.model.Bank


@Database(
    entities = [Bank::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class BankDatabase: RoomDatabase() {

    abstract fun bankDao(): BankDao

}