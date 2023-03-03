package com.example.teayudaapp.randomscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.homescreen.presentation.components.HomePost
import com.example.teayudaapp.homescreen.presentation.components.HomeTopBar
import java.time.LocalDate

@Composable
fun RandomScreen(
    profileClicked: () -> Unit,
    bottomBar: @Composable () -> Unit,
    modifier: Modifier = Modifier
){
    val scaffoldState = rememberScaffoldState()
    val searchText = remember { mutableStateOf("") }
    
    Scaffold(
        modifier = modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = { HomeTopBar(onClick = { profileClicked() }, searchText = searchText )},
        bottomBar = { bottomBar() }
    ) { paddingValues ->  
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 10.dp,
                    end = 10.dp
                ),
            verticalArrangement = Arrangement.SpaceAround,
            //horizontalAlignment = Alignment.CenterHorizontally
        ){
            item { 
                Text(
                    text = "Publicaciones aleatorias",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
            }
            items(10){
                HomePost(
                    textPost = "Some text",
                    imagePost = "https://via.placeholder.com/1000",
                    datePost = LocalDate.now().toString(),
                    imageUser = "https://via.placeholder.com/200",
                    userName = "User name",
                    hashTag = "#Gogo",
                    voteUpCount = 1,
                    voteDownCount = 10,
                    favouritePost = false
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RandomScreenPreview(){
    RandomScreen({}, {})
}