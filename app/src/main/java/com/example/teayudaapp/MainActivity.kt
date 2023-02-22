package com.example.teayudaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.teayudaapp.sharedcomponents.Navigation
import com.example.teayudaapp.ui.theme.TEAyudaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TEAyudaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Directly added for demo and presentations
                    //Content of navigation
                    //TODO: Create the Navigation Structure, from "navigation compose"

                    //RegisterScreen()
                    //HomeScreen()
                    //FavouritesScreen()
                    Navigation()
                    //ProfileScreen({})
                    //RandomScreen(profileClicked = { /*TODO*/ }, {})
                    //MessageScreen(bottomBar = { /*TODO*/ }, {})
                    //MessageIndividual(message = "Some message", ownMessage = false)
                }
            }
        }
    }
}

