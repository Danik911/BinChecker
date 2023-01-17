package com.example.binchecker.presentation.onboarding_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.model.Country
import com.example.binchecker.domain.model.Number
import com.example.binchecker.domain.use_cases.get_all_banks.GetApiResponseUseCase
import com.example.binchecker.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val getApiResponseUseCase: GetApiResponseUseCase,

) : ViewModel() {

    private val _apiResponse = mutableStateOf(
        ApiResponse(
            bank = Bank(

                city = "Empty",
                bankName = "Empty",
                phone = "Empty",
                url = "Empty"
            ),
            brand = "Empty",
            country = Country(
                alpha2 = "Empty",
                currency = "Empty",
                emoji = "Empty",
                latitude = 0,
                longitude = 0,
                countryName = "Empty",
                numeric = "Empty"
            ),
            number = Number(
                length = 0,
                luhn = true
            ),
            prepaid = true,
            scheme = "Empty",
            type = "Empty"
        )
    )
    val apiResponse: State<ApiResponse?> = _apiResponse

    init {
        getApiResponse()
    }

    /* private fun getApiResponse() {
         getApiResponseUseCase().onEach { result ->
             when (result) {
                 is Resource.Success -> {
                     _state.value = CoinListState(coins = result.data ?: emptyList())
                 }
                 is Resource.Error -> {
                     _state.value = CoinListState(
                         error = result.message ?: "An unexpected error occured"
                     )
                 }
                 is Resource.Loading -> {
                     _state.value = CoinListState(isLoading = true)
                 }
             }
         }.launchIn(viewModelScope)
     }*/
    private fun getApiResponse() {
        viewModelScope.launch {
            val apiResponse = getApiResponseUseCase()

            when (apiResponse) {
                is Resource.Success -> {
                    _apiResponse.value = apiResponse.data!!
                }
                is Resource.Error -> {
                    Timber.d("Error occur")
                }
                else -> {
                    Timber.d("Error occur")
                }
            }
        }
    }
}