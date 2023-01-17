package com.example.binchecker.domain.model

sealed interface ApiResponseUiState {
    data class Success(val photos: String) : ApiResponseUiState
    object Error : ApiResponseUiState
    object Loading : ApiResponseUiState
}
