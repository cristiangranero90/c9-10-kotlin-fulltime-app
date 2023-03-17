package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.teayudaapp.registerscreen.domain.SharedStringsResources

@Composable
fun ForgottenPassword(
    padding: Dp,
    dataString: SharedStringsResources,
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = padding, end = padding),
        contentAlignment = Alignment.TopEnd,
    ){
        Text(
            text = stringResource(id = dataString.termsOrForgottenId),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ForgottenPasswordPreview(){
    //ForgottenPassword()
}