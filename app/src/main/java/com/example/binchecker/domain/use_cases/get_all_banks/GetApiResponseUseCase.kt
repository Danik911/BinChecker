package com.example.binchecker.domain.use_cases.get_all_banks

import com.example.binchecker.data.repository.Repository
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.util.Resource
import timber.log.Timber
import javax.inject.Inject

class GetApiResponseUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(bin: String): ApiResponse {
        Timber.d("GetApiResponse called")
        return repository.getApiResponse(bin)
    }
}