package com.example.binchecker.di

import android.content.Context
import androidx.room.Room
import com.example.binchecker.data.local.BankDatabase
import com.example.binchecker.data.repository.LocalDataSourceImpl
import com.example.binchecker.domain.repository.LocalDataSource
import com.example.binchecker.util.Constants.BANK_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BankDatabase::class.java,
        BANK_DATABASE
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: BankDatabase) = database.bankDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: BankDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            bankDatabase = database
        )
    }

}