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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.messagescreen.components.MessageIndividual
import com.example.teayudaapp.messagescreen.components.MessageIndividualTopBar
import com.example.teayudaapp.messagescreen.components.MessageItem
import com.example.teayudaapp.messagescreen.components.MessagesTopBar

@Composable
fun MessageScreen(
    bottomBar: @Composable () -> Unit,
    onClose: () -> Unit,
    viewModel: MessageViewModel = hiltViewModel()
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
                    profileImage = "https://c2e9a7e8.rocketcdn.me/wp-content/uploads/2023/01/openAI-chat-gpt-1.jpg",
                    profileName = "Chat GPT",
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
            MessageIndividual({},paddingValues = paddingValues)
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
                        top = paddingValues.calculateTopPadding() + 10.dp,
                        bottom = paddingValues.calculateBottomPadding(),
                        start = 10.dp,
                        end = 10.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(2) {
                    //TODO: Message items from database
                    MessageItem(
                        profileImageUrl = "https://c2e9a7e8.rocketcdn.me/wp-content/uploads/2023/01/openAI-chat-gpt-1.jpg",
                        profileName = "Chat GPT",
                        messageText = "Envia y recibe mensajes al instante...",
                        onClick = { individual.value = !individual.value }
                    )
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