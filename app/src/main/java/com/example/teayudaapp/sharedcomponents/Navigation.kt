package com.example.teayudaapp.sharedcomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.teayudaapp.favouritesscreen.FavouritesScreen
import com.example.teayudaapp.homescreen.presentation.HomeScreen
import com.example.teayudaapp.messagescreen.MessageScreen
import com.example.teayudaapp.postcreationscreen.presentation.CreatePost
import com.example.teayudaapp.profilescreen.ProfileScreen
import com.example.teayudaapp.randomscreen.RandomScreen
import com.example.teayudaapp.registerscreen.presentation.RegisterScreen
import com.example.teayudaapp.splashscreen.SplashScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    //Bottom Navigation Bar
    val bottomNav: @Composable () -> Unit = {
        BottomBar(
            onHomeClicked = {
                navController.navigate("home_screen") {
                    popUpTo("home_screen")
                    launchSingleTop = true
                    restoreState = true
                }
            },
            onRandomClicked = {
                navController.navigate("random_screen") {
                    popUpTo("random_screen")
                    launchSingleTop = true
                    restoreState = true
                }
            },
            onMessageClicked = {
                navController.navigate("message_screen") {
                    popUpTo("message_screen")
                    launchSingleTop = true
                    restoreState = true
                }
            },
            onFavouritesClicked = {
                navController.navigate("favourites_screen") {
                    popUpTo("favourites_screen")
                    launchSingleTop = true
                    restoreState = true
                }
            },
            currentDestination,
        )
    }

    NavHost(
        navController = navController,
        startDestination = "splash_screen",
    ) {
        //TODO: Hardcoded entry, create enum class or sealed class
        composable("splash_screen"){
            SplashScreen { navController.navigate("register_screen") }
        }
        composable("register_screen"){
            RegisterScreen( { navController.navigate("home_screen")} )
        }
        composable("home_screen"){
            HomeScreen(
                bottomNav ,
                { navController.navigate("profile_screen") },
                { navController.navigate("create-post_screen") }
            )
        }
        composable("create-post_screen"){
            CreatePost( { navController.navigateUp() })
        }
        composable("favourites_screen"){
            FavouritesScreen( { navController.navigate("profile_screen") }, bottomNav)
        }
        composable("profile_screen"){
            ProfileScreen(
                { navController.navigate("register_screen")
                    {
                    popUpTo("register_screen")
                    launchSingleTop = true
                    restoreState = false
                    }
                },
                bottomNav)
        }
        composable("random_screen") {
            RandomScreen(profileClicked = { navController.navigate("profile_screen") }, bottomNav)
        }
        composable("message_screen") {
            MessageScreen(bottomBar = bottomNav, onClose = { navController.navigateUp() })
        }
    }


}