package com.example.teayudaapp.homescreen.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.homescreen.presentation.components.HomePost
import com.example.teayudaapp.sharedcomponents.BottomBar
import com.example.teayudaapp.homescreen.presentation.components.HomeTopBar
import com.example.teayudaapp.homescreen.presentation.components.HomeViewList
import com.example.teayudaapp.postcreationscreen.presentation.CreatePost
import java.time.LocalDate

@Composable
fun HomeScreen(
    bottomNav: @Composable () -> Unit,
    goCreatePost: () -> Unit,
){

    val scaffoldState = rememberScaffoldState()
    val searchText = remember { mutableStateOf("") }
    val createPost = remember { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        bottomBar = {bottomNav()},
        floatingActionButton = {
            FloatingActionButton(
                onClick = goCreatePost,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 2.dp),
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colors.primaryVariant,
                        shape = CircleShape),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Create a new post",
                    tint = MaterialTheme.colors.primaryVariant,
                   )
            }
        },
        topBar = { HomeTopBar(searchText) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){ paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            HomeViewList()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(10.dp),
            ) {
                //Hardcoded items
                item {
                    HomePost(
                        textPost = "Something to show",
                        imagePost = "https://via.placeholder.com/600 ",
                        voteUpCount = 1,
                        voteDownCount = 1,
                        favouritePost = false,
                        datePost = LocalDate.now(),
                        imageUser = null,
                        userName = "Some one",
                        hashTag = "#Go go")
                }
                item {
                    HomePost(
                        textPost = "Something to show",
                        imagePost = "https://via.placeholder.com/600 ",
                        voteUpCount = 1,
                        voteDownCount = 1,
                        favouritePost = false,
                        datePost = LocalDate.now(),
                        imageUser = null,
                        userName = "Some one",
                        hashTag = "#Go go")
                }
                item {
                    HomePost(
                        textPost = "Something to show",
                        imagePost = null,
                        voteUpCount = 1,
                        voteDownCount = 1,
                        favouritePost = true,
                        datePost = LocalDate.now(),
                        imageUser = null,
                        userName = "Some one",
                        hashTag = "#Go go")
                }
                item {
                    HomePost(
                        textPost = "Something to show",
                        imagePost = "https://via.placeholder.com/600 ",
                        voteUpCount = 1,
                        voteDownCount = 1,
                        favouritePost = true,
                        datePost = LocalDate.now(),
                        imageUser = null,
                        userName = "Some one",
                        hashTag = "#Go go")
                }
                item {
                    HomePost(
                        textPost = "Something to show",
                        imagePost = "https://via.placeholder.com/600 ",
                        voteUpCount = 1,
                        voteDownCount = 1,
                        favouritePost = false,
                        datePost = LocalDate.now(),
                        imageUser = null,
                        userName = "Some one",
                        hashTag = "#Go go")
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen({}, {})
}