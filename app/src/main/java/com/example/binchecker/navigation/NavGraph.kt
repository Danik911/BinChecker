package com.example.binchecker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.binchecker.presentation.history_screen.HistoryScreen
import com.example.binchecker.presentation.main_screen.MainScreen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(Screen.History.route) {
          HistoryScreen()
        }
    }
}