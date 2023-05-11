package com.example.proguard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.proguard.presentation.navigation.MainNavGraph
import com.example.proguard.ui.theme.ProguardTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProguardTheme {
                MainNavGraph(navHostController = rememberNavController())
            }
        }
    }
}