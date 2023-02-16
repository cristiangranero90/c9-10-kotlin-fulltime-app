package com.example.teayudaapp.favouritesscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teayudaapp.favouritesscreen.components.FavouritesTopBar
import com.example.teayudaapp.favouritesscreen.components.NoFavouritesAdded

@Composable
fun FavouritesScreen(
    bottomNav: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    val noFavourites = remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { FavouritesTopBar(buttonProfile = { /*TODO*/ }) },
        bottomBar = bottomNav,

    ) { paddingValues ->

        if (noFavourites.value) {
            NoFavouritesAdded()
        }
        else{
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ){
                item {
                    Text(text = "Something")
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun FavouritesScreenPreview() {
    FavouritesScreen({})
}