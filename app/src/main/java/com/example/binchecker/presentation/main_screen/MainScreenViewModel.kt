package com.example.binchecker.presentation.main_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.model.Country
import com.example.binchecker.domain.use_cases.GetApiResponseUseCase
import com.example.binchecker.util.MessageBarState
import com.example.binchecker.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getApiResponseUseCase: GetApiResponseUseCase,

    ) : ViewModel() {


    private var _apiResponseState: MutableState<RequestState<ApiResponse>> =
        mutableStateOf(RequestState.Idle)
    val apiResponseState: State<RequestState<ApiResponse>> = _apiResponseState

    private val _messageBarState: MutableState<MessageBarState> = mutableStateOf(MessageBarState())
    val messageBarState: State<MessageBarState> = _messageBarState

    private val _country: MutableState<Country?> = mutableStateOf(null)
    val country: State<Country?> = _country

    private val _binBank: MutableState<String> = mutableStateOf("")
    val binBank: State<String> = _binBank

    private val _bank: MutableState<Bank?> = mutableStateOf(null)
    val bank: State<Bank?> = _bank


    fun getApiBinResponse(binBank: String) {
        _apiResponseState.value = RequestState.Loading
        try {
            viewModelScope.launch {
                val response = getApiResponseUseCase(binBank)

                _apiResponseState.value = RequestState.Success(data = response)
                _bank.value = response.bank
                _messageBarState.value =
                    MessageBarState(message = response.success.parseResult(), error = response.error)
                Timber.d("$response")

            }
        } catch (e: Exception) {
            _apiResponseState.value = RequestState.Error(t = e)
            _messageBarState.value = MessageBarState(error = e)
        }

    }

    fun updateBinBank(newName: String) {
        if (newName.length <= 8) {
            _binBank.value = newName
        }
    }
    fun resetMessageBar(){
        _messageBarState.value = MessageBarState()
    }
    private fun Boolean.parseResult(): String{
        return if (this) "Success" else "Fail"
    }
}




