package com.example.binchecker.presentation.onboarding_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binchecker.data.local.BankDatabase
import com.example.binchecker.domain.model.ApiResponseUiState
import com.example.binchecker.domain.use_cases.get_all_banks.GetApiResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val getApiResponseUseCase: GetApiResponseUseCase,
    private val database: BankDatabase
) : ViewModel() {

    val bankDao = database.bankDao()

    var apiResponseUiState: ApiResponseUiState by mutableStateOf(ApiResponseUiState.Loading)
        private set

    init {
        getApiBinResponse()
    }


    private fun getApiBinResponse() {
        viewModelScope.launch {
            apiResponseUiState = try {
                val result = getApiResponseUseCase("45717360")
                bankDao.insertBank(result.bank)
                ApiResponseUiState.Success("Success $result ")
            } catch (e: IOException) {
                ApiResponseUiState.Error
            } catch (e: HttpException) {
                ApiResponseUiState.Error
            }

        }
    }
}
