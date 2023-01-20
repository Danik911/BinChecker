package com.example.binchecker.presentation.history_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.use_cases.DeleteAllBanksUseCase
import com.example.binchecker.domain.use_cases.DeleteBankUseCase
import com.example.binchecker.domain.use_cases.GetAllBanksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    getAllBanksUseCase: GetAllBanksUseCase,
    private val deleteAllBanksUseCase: DeleteAllBanksUseCase,
    private val deleteBankUseCase: DeleteBankUseCase
) :
    ViewModel() {


    val allBanks: StateFlow<List<Bank>> = getAllBanksUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = listOf()
    )

    fun deleteAllBanks(){
        viewModelScope.launch {
            deleteAllBanksUseCase()
        }
    }

    fun deleteBank(bank: Bank){
        viewModelScope.launch {
            deleteBankUseCase(bank = bank)
        }
    }
}