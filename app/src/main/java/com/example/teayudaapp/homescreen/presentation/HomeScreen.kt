package com.example.teayudaapp.homescreen.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teayudaapp.homescreen.presentation.components.BottomBar
import com.example.teayudaapp.homescreen.presentation.components.HomeTopBar

@Composable
fun HomeScreen(){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Create a new post")
            }
        },
        topBar = { HomeTopBar() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){ paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(text = "One text")
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}