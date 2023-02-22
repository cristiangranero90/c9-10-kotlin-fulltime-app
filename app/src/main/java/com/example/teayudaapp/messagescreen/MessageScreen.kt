package com.example.teayudaapp.messagescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.messagescreen.components.MessageItem
import com.example.teayudaapp.messagescreen.components.MessagesTopBar

@Composable
fun MessageScreen(
    bottomBar: @Composable () -> Unit,
    onClose: () -> Unit,
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        bottomBar = { bottomBar() },
        topBar = { MessagesTopBar( { onClose() } ) }

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
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(10) {
                //TODO: Message items from database
                MessageItem(
                    profileImageUrl = "https://via.placeholder.com/200",
                    profileName = "Some name",
                    messageText = "Some message from the future just read it llkjasljkdklajsdkljsldjksdljsdljklasjkl"
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun MessageScreenPreview() {
    MessageScreen({}, {})
}