package com.example.proguard.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proguard.presentation.main.MainViewModel
import com.example.proguard.presentation.main.components.MainScreen

@Composable
fun MainNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "main"
    ){
        composable("main"){
            val viewModel = hiltViewModel<MainViewModel>()
            val state = viewModel.state
            MainScreen(state = state)
        }
    }
}