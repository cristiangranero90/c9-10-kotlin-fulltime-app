package com.example.teayudaapp.ui.composable.sharedcomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.teayudaapp.ui.composable.registerscreen.RegisterScreen
import com.example.teayudaapp.ui.composable.splashscreen.SplashScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavHost(navController = navController, startDestination = "splash_screen") {

        //TODO: Hardcoded entry, create enum class or sealed class
        composable("splash_screen"){
            SplashScreen()
        }

        composable("register_screen"){
            RegisterScreen()
        }
    }
}