package com.example.teayudaapp.homescreen.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teayudaapp.homescreen.presentation.components.BottomBar
import com.example.teayudaapp.homescreen.presentation.components.HomeTopBar

@Composable
fun HomeScreen(){

    val scaffoldState = rememberScaffoldState()
    val searchText = remember { mutableStateOf("") }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Create a new post",
                    tint = MaterialTheme.colors.primaryVariant)
            }
        },
        topBar = { HomeTopBar(searchText) },
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