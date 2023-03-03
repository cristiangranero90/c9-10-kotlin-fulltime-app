package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageIndividual(
    onSendClick: () -> Unit,
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
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding() + 10.dp)
    ) {
        LazyColumn(
            modifier = modifier
                .weight(1f)
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                .fillMaxWidth(),
            reverseLayout = true,
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(10){
                MessageIndividualItem(message = "Some message from the future \n Hi everyone", ownMessage = own)
                Spacer(modifier = Modifier.height(10.dp))
                own = !own
            }
            //Text field box TODO: Input string
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(49.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = writtenMessage.value,
                    onValueChange = { writtenMessage.value = it },
                    Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(27.dp),
                    singleLine = true,
                    maxLines = 1,
                    textStyle = MaterialTheme.typography.body2,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        backgroundColor = MaterialTheme.colors.primaryVariant,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "Envia mensaje...",
                            color = Color.Black,
                            style = MaterialTheme.typography.caption
                        )},
                    leadingIcon = {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(shape = CircleShape)
                                .background(Color(0xFF5175FD))
                                .clickable { onSendClick() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon( Icons.Default.Send, contentDescription = "Send", tint = Color.White)
                        }
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MessageIndividualPreview() {
    MessageIndividual({},PaddingValues(10.dp))
}