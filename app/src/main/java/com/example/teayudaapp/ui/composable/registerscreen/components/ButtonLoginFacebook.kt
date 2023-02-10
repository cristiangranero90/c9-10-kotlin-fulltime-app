package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLoginFacebook(
    dataString: SharedStringsResources,
    colorsButton: Color,
) {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorsButton)
    ) {

        Text(
            text = stringResource(id = dataString.registerButton) + " ",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary
        )

        Icon(
            imageVector = Icons.Default.Facebook,
            contentDescription = "Facebook login",
            tint = MaterialTheme.colors.onSecondary)
    }
}