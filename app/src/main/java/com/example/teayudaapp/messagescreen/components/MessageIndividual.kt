package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageIndividual(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    var own = true
    val writtenMessage = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        LazyColumn(
            modifier = modifier
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
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
        //Text field box TODO: Input string
        Box(modifier = Modifier.fillMaxWidth().height(65.dp)) {
            TextField(
                value = writtenMessage.value,
                onValueChange = { writtenMessage.value = it },
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(27.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MessageIndividualPreview() {
    MessageIndividual(PaddingValues(10.dp))
}