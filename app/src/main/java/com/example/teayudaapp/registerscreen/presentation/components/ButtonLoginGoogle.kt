package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R
import com.example.teayudaapp.registerscreen.domain.SharedStringsResources

@Composable
fun ButtonLoginGoogle(
    onGoogleClicked: () -> Unit,
    dataString: SharedStringsResources,
    colorsButton: Color,
) {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { onGoogleClicked() },
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorsButton)
    ) {
        Text(
            text = stringResource(id = dataString.registerButton) + " ",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSecondary
        )
        Icon(
            painterResource(id = R.drawable.google_icon),
            contentDescription = "Google sign up",
            tint = MaterialTheme.colors.onSecondary)
    }
}