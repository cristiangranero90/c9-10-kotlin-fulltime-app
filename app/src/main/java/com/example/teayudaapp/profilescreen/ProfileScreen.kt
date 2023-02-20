package com.example.teayudaapp.profilescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.teayudaapp.profilescreen.components.ProfileImage
import com.example.teayudaapp.profilescreen.components.ProfileTopBar

@Composable
fun ProfileScreen(
    bottomNav: @Composable () -> Unit
) {

    val scaffoldState = rememberScaffoldState()
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ProfileTopBar(buttonEdit = { /*TODO*/ } )},
        bottomBar = bottomNav,
        scaffoldState = scaffoldState

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            item {
                ProfileImage(name = "Profile Name", imageUrl = "https://via.placeholder.com/1000")
            }
        }
    }



}


@Composable
@Preview(showBackground = true, showSystemUi = true, name = "profile_screen")
fun ProfileScreenPreview(){
    ProfileScreen({ })
}