package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageIndividualItem(
    message: String,
    ownMessage: Boolean,
    modifier: Modifier = Modifier,
){
    val horizontal = if (ownMessage) Arrangement.End else Arrangement.Start
    val modifierClips = if (ownMessage) Modifier.clip(shape = RoundedCornerShape(
        topStart = 13.dp,
        topEnd = 13.dp,
        bottomEnd = 0.dp,
        bottomStart = 13.dp))
    else
        Modifier.clip(shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 13.dp,
            bottomEnd = 13.dp,
            bottomStart = 13.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontal
    ) {
        Box(
            modifier = modifierClips
                .width(288.dp)
                .background(MaterialTheme.colors.primaryVariant)
                .padding(10.dp)
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSecondary
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MessageIndividualItemPreview(){
    MessageIndividualItem("Some text for you ", false)
}