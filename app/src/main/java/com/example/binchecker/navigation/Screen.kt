package com.example.binchecker.navigation


sealed class Screen(val route: String) {

    object Main : Screen("main_screen")
    object History : Screen("history_screen")

}

