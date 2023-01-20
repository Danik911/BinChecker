package com.example.binchecker.presentation.history_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binchecker.domain.model.ApiResponse
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.use_cases.get_all_banks.GetAllBanksUseCase
import com.example.binchecker.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val getAllBanksUseCase: GetAllBanksUseCase) :
    ViewModel() {




    val allBanks: StateFlow<List<Bank>> = getAllBanksUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = listOf()
    )

   /* private fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allTasks.value = RequestState.Error(e)
        }
    }*/

}