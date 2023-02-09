package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLoginFacebook() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
    ) {

        Text(
            text = "Iniciar sesion con ",
            style = MaterialTheme.typography.body1
        )
        Icon(imageVector = Icons.Default.Facebook, contentDescription = "Facebook login")
    }
}