package com.example.teayudaapp.profilescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.profilescreen.components.ProfileBiography
import com.example.teayudaapp.profilescreen.components.ProfileImage
import com.example.teayudaapp.profilescreen.components.ProfileTopBar

@Composable
fun ProfileScreen(
    bottomNav: @Composable () -> Unit,
    viewModel: ProfileViewModel = hiltViewModel(),
) {

    val scaffoldState = rememberScaffoldState()
    val biography = remember {
        mutableStateOf(viewModel.state.profileBio)
    }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ProfileTopBar(buttonEdit = { /*TODO*/ } )},
        bottomBar = bottomNav,
        scaffoldState = scaffoldState

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 20.dp, end = 20.dp
                )
        ){
            item {
                ProfileImage(name = "Profile Name", imageUrl = "https://via.placeholder.com/1000")
            }
            item {
                ProfileBiography(
                    biography = biography ,
                    isEditable = !viewModel.state.isEditable,
                    createdDate = viewModel.state.profileDate
                )
            }

            items(10){

            }
        }
    }



}


@Composable
@Preview(showBackground = true, showSystemUi = true, name = "profile_screen")
fun ProfileScreenPreview(){
    ProfileScreen({ })
}