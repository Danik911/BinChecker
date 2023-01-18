package com.example.binchecker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.binchecker.navigation.SetupNavigation
import com.example.binchecker.presentation.ui.theme.BinCheckerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BinCheckerTheme {
                val navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}


