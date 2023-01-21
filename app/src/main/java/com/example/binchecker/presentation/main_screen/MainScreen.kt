package com.example.binchecker.presentation.main_screen

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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
    val bank by mainViewModel.bank
    val context = LocalContext.current


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
                bank = bank,
                onBinBankChanged = {
                    mainViewModel.updateBinBank(it)
                },

                onSearchClicked = {
                    mainViewModel.getApiBinResponse(binBank)

                },
                onBankLinkClicked = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://medium.com/")
                    )
                    val pendingIntent = TaskStackBuilder.create(context).run {
                        addNextIntentWithParentStack(intent)
                        getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                        )
                    }
                    pendingIntent.send()
                }
            )
        }
    )
}
private fun onBankLinkClicked(link: String, context: Context){
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(link)
    )
    val pendingIntent = TaskStackBuilder.create(context).run {
        addNextIntentWithParentStack(intent)
        getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
    pendingIntent.send()
}

