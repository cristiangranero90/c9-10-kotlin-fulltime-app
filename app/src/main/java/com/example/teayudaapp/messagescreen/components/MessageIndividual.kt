package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageIndividual(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    var own = true
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        reverseLayout = true,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
       items(10){
           MessageIndividualItem(message = "Some message from the future \n Hi everyone", ownMessage = own)
           Spacer(modifier = Modifier.height(10.dp))
           own = !own
       }
    }
}

@Composable
@Preview(showBackground = true)
fun MessageIndividualPreview() {
    MessageIndividual(PaddingValues(10.dp))
}