package com.example.teayudaapp.homescreen.presentation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.homescreen.presentation.components.HomePost
import com.example.teayudaapp.homescreen.presentation.components.HomeTopBar
import com.example.teayudaapp.homescreen.presentation.components.HomeViewList
import com.example.teayudaapp.sharedcomponents.ExitDialog
import com.example.teayudaapp.sharedcomponents.LoadingDialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    bottomNav: @Composable () -> Unit,
    profileClicked: () -> Unit,
    goCreatePost: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
){
    val activity = LocalContext.current as Activity
    val scaffoldState = rememberScaffoldState()
    val searchText = remember { mutableStateOf("") }
    val refreshState = rememberPullRefreshState(
        refreshing = viewModel.state.isRefreshing,
        onRefresh = { viewModel.reloadAll() }
    )
    if (viewModel.state.showDialog) {
        ExitDialog(onDismiss = { viewModel.showDialog() }) {
            activity.finish()
        }
    }
    if (viewModel.state.isLoading){
        LoadingDialog()
    }
    BackHandler(viewModel.isActiveUser()) {
        viewModel.showDialog()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        bottomBar = {bottomNav()},
        floatingActionButton = {
            FloatingActionButton(
                onClick = goCreatePost,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 2.dp),
                backgroundColor = Color(0xFF7286D3),
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
        topBar = { HomeTopBar(viewModel.getOwnImage(), profileClicked, searchText) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ){ paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            HomeViewList()

            Box(modifier = Modifier.pullRefresh(refreshState, true) ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(10.dp),
                ) {
                    //Hardcoded items
                    items( viewModel.state.posts.size){ index ->
                        val user = viewModel.getUser(viewModel.state.posts[index].userId)
                        HomePost(
                            textPost = viewModel.state.posts[index].postData,
                            imagePost = viewModel.state.posts[index].imageUrl,
                            datePost = viewModel.state.posts[index].createDate,
                            imageUser = user?.imageUrl ?: "Nothing",
                            userName = user?.name ?: "No user",
                            hashTag = viewModel.state.posts[index].hashTag.toString(),
                            voteUpCount = viewModel.state.posts[index].upVote,
                            voteDownCount = viewModel.state.posts[index].downVote,
                            favouritePost = viewModel.isFavourite(viewModel.state.posts[index]) ,
                            onFavouritesClicked = { viewModel.addToFavourites(viewModel.state.posts[index]) }
                        )
                    }
                }
                PullRefreshIndicator(
                    viewModel.state.isRefreshing,
                    refreshState,
                    Modifier.align(Alignment.TopCenter),
                    contentColor = MaterialTheme.colors.primary
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen({}, {}, {})
}