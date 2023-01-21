package com.example.binchecker.presentation.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.binchecker.navigation.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainScreenViewModel = hiltViewModel()
) {
    val apiResponse by mainViewModel.apiResponseState
    val messageBarState by mainViewModel.messageBarState
    val binBank by mainViewModel.binBank
    val country by mainViewModel.country


    Scaffold(topBar = {
        MainScreenTopAppBar(
            onHistoryClicked = {
                navController.navigate(Screen.History.route)
                mainViewModel.resetMessageBar()
            }
        )
    },
        content = {
            MainScreenContent(
                apiResponse = apiResponse,
                messageBarState = messageBarState,
                binBank = binBank,
                bank = mainViewModel.bank.value,
                onBinBankChanged = {
                    mainViewModel.updateBinBank(it)
                },

                onSearchClicked = {
                    mainViewModel.getApiBinResponse(binBank)

                }
            )
        }
    )
}
