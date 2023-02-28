package com.example.teayudaapp.profilescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.profilescreen.components.ProfileBiography
import com.example.teayudaapp.profilescreen.components.ProfileImage
import com.example.teayudaapp.profilescreen.components.ProfilePostView
import com.example.teayudaapp.profilescreen.components.ProfileTopBar
import java.time.LocalDate

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
        topBar = { ProfileTopBar(buttonEdit = { viewModel.changeEdit(biography.value) } )},
        bottomBar = bottomNav,
        scaffoldState = scaffoldState,

    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 6.dp, end = 6.dp
                ),
        ){
            item {
                ProfileImage(
                    name = viewModel.state.profileName,
                    imageUrl = viewModel.state.profileImage,
                    onCloseClicked = { viewModel.closeSession() }
                )
            }
            item {
                ProfileBiography(
                    biography = biography ,
                    isEditable = !viewModel.state.isEditable,
                    createdDate = viewModel.state.profileDate
                )
            }

            item {
                Text(
                    text = "Post",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            if(viewModel.state.post.isNotEmpty()){
                items(viewModel.state.post.size - 1){
                    ProfilePostView(
                        userImage = "https://via.placeholder.com/200",
                        userName = "Post name",
                        date = LocalDate.now(),
                        postText = viewModel.state.profileBio,
                        postImage = "",
                        hashtag = "Gogo"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            else {
                item {
                    Text(text = "Aun no creaste ningun post... Intenta crear uno!", style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true, name = "profile_screen")
fun ProfileScreenPreview(){
    ProfileScreen({ })
}