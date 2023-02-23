package com.example.teayudaapp.messagescreen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.messagescreen.components.MessageIndividual
import com.example.teayudaapp.messagescreen.components.MessageIndividualTopBar
import com.example.teayudaapp.messagescreen.components.MessageItem
import com.example.teayudaapp.messagescreen.components.MessagesTopBar

@Composable
fun MessageScreen(
    bottomBar: @Composable () -> Unit,
    onClose: () -> Unit,
) {
    val scaffoldState = rememberScaffoldState()
    val individual = remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        bottomBar = { bottomBar() },
        topBar = {
            if (individual.value){
                MessageIndividualTopBar(
                    profileImage = "https://via.placeholder.com/200",
                    profileName = "Some name",
                    onClick = { individual.value = !individual.value })
            } else{
                MessagesTopBar( { onClose() } )
            }
        }

    ) { paddingValues ->

        AnimatedVisibility(
            visible = individual.value,
            modifier = Modifier.fillMaxWidth(),
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut(),
        ) {
            MessageIndividual(paddingValues = paddingValues)
        }

        AnimatedVisibility(
            visible = !individual.value,
            modifier = Modifier.fillMaxWidth(),
            enter = slideInHorizontally() + fadeIn(),
        ) {
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
                        messageText = "Some message from the future just read it llkjasljkdklajsdkljsldjksdljsdljklasjkl",
                        onClick = { individual.value = !individual.value }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun MessageScreenPreview() {
    MessageScreen({}, {})
}