package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar(){
    TopAppBar(
        modifier = Modifier.height(128.dp),
        title = { TextField(value = "", onValueChange = {} ) },
        navigationIcon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Go to home screen" )},
        actions = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile side")}
    )
}

@Composable
@Preview(showBackground = true)
fun HomeTopBarPreview(){
    HomeTopBar()
}