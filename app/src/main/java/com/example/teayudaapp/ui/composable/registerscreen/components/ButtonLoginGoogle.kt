package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun ButtonLoginGoogle() {
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
        Icon(painterResource(id = R.drawable.google_icon), contentDescription = "Google login")
    }
}