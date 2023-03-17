package com.example.teayudaapp.messagescreen

import androidx.activity.compose.BackHandler
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
    val individualImage = remember {
        mutableStateOf("")
    }
    val individualName = remember {
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val individual = remember {
        mutableStateOf(false)
    }
    BackHandler(individual.value) {
        individual.value = !individual.value
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        bottomBar = { bottomBar() },
        topBar = {
            if (individual.value){
                MessageIndividualTopBar(
                    profileImage = individualImage.value,
                    profileName = individualName.value,
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
                items(10) {
                    //TODO: Message items from database
                    MessageItem(
                        profileImageUrl = viewModel.state.images[it],
                        profileName = viewModel.state.names[it],
                        messageText = "Envia y recibe mensajes al instante...",
                        onClick = {
                            individual.value = !individual.value
                            individualImage.value = viewModel.state.images[it]
                            individualName.value = viewModel.state.names[it]
                        }
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