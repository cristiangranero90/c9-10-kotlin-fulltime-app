package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageIndividual(
    message: String,
    modifier: Modifier = Modifier,
){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 13.dp,
                bottomEnd = 13.dp,
                bottomStart = 13.dp)
            )
            .background(MaterialTheme.colors.primaryVariant)

    ) {

    }

}

@Composable
@Preview(showBackground = true)
fun MessageIndividualPreview(){
    MessageIndividual("")
}