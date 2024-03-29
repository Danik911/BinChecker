package com.example.binchecker.domain.repository

import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getApiResponse(bin: String): ApiResponse
}