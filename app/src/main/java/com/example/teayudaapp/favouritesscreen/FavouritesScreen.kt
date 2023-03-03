package com.example.teayudaapp.favouritesscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.favouritesscreen.components.FavouritesTopBar
import com.example.teayudaapp.favouritesscreen.components.NoFavouritesAdded
import com.example.teayudaapp.homescreen.presentation.components.HomePost
import com.example.teayudaapp.sharedcomponents.LoadingDialog

@Composable
fun FavouritesScreen(
    buttomProfile: () -> Unit,
    bottomNav: @Composable () -> Unit,
    viewModel: FavouritesViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {

    if (viewModel.state.isLoading) {
        LoadingDialog()
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { FavouritesTopBar(buttonProfile = { buttomProfile() }) },
        bottomBar = bottomNav,

    ) { paddingValues ->

        if (viewModel.state.favouritesPost.isEmpty()) {
            NoFavouritesAdded()
        }
        else{
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(10.dp),
            ){
                items( viewModel.state.favouritesPost.size) { index ->
                    var user = viewModel.getUser(viewModel.state.favouritesPost[index].userId)
                    HomePost(
                        textPost = viewModel.state.favouritesPost[index].postData,
                        imagePost = viewModel.state.favouritesPost[index].imageUrl,
                        datePost = viewModel.state.favouritesPost[index].createDate,
                        imageUser = user?.imageUrl ?: "Nothing",
                        userName = user?.name ?: "No user",
                        hashTag = viewModel.state.favouritesPost[index].hashTag.toString(),
                        voteUpCount = viewModel.state.favouritesPost[index].upVote,
                        voteDownCount = viewModel.state.favouritesPost[index].downVote,
                        favouritePost = true ,
                        onFavouritesClicked = { /*TODO: Do nothing or delete post */ },
                        tittle = viewModel.state.favouritesPost[index].title
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun FavouritesScreenPreview() {
    FavouritesScreen({}, {})
}