package com.example.binchecker.presentation.history_screen

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.binchecker.domain.model.Bank

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun HistoryScreen(
    historyViewModel: HistoryViewModel = hiltViewModel()
) {


    val allTasks: List<Bank> by historyViewModel.allBanks.collectAsStateWithLifecycle()

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HistoryTopAppBar(
                onDeleteAllConfirmed = { }
            )
        },
        content = {
            HistoryScreenContent(
                banks = allTasks,
                onSwipeToDelete = {}
            )

        },

        )
}






