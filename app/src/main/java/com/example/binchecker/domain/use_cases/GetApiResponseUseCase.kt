package com.example.binchecker.domain.use_cases

import com.example.binchecker.data.repository.Repository
import com.example.binchecker.domain.model.ApiResponse
import timber.log.Timber
import javax.inject.Inject

class GetApiResponseUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(bin: String): ApiResponse {
        return repository.getApiResponse(bin)
    }
}