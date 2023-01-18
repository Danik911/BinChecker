package com.example.binchecker.presentation.main_screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.binchecker.navigation.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalCoilApi
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
            onHistoryClicked = { navigateToHistoryScreen(navController = navController) }
        )
    },
        content = {
            MainScreenContent(
                apiResponse = apiResponse,
                messageBarState = messageBarState,
                binBank = binBank,
                onBinBankChanged = {
                    mainViewModel.updateBinBank(it)
                },

                profilePhoto = country?.emoji,
                onSearchClicked = {
                    mainViewModel.getApiBinResponse(binBank)
                }
            )
        }

    )

}


private fun navigateToHistoryScreen(navController: NavHostController) {
    navController.navigate(Screen.History.route) {
        popUpTo(Screen.Main.route) {
            inclusive = true
        }
    }
}
