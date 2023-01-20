package com.example.binchecker.di

import com.example.binchecker.data.repository.Repository
import com.example.binchecker.domain.use_cases.GetApiResponseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideGetApiResponse(repository: Repository): GetApiResponseUseCase {
        return GetApiResponseUseCase(
           repository = repository
        )
    }

}