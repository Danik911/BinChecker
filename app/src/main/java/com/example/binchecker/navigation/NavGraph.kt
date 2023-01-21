package com.example.binchecker.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binchecker.presentation.history_screen.HistoryScreen
import com.example.binchecker.presentation.main_screen.MainScreen

@OptIn( ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
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