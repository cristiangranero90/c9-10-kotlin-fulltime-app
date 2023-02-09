package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RegisterLoginButtons(
    padding: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium) {
                Text(
                    text = "Registrar",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSecondary)
            }
            Divider(
                modifier = Modifier
                    .height(30.dp)
                    .width(1.dp)
                    .background(Color.White)
            )
            Button(onClick = { /*TODO*/ }, shape = MaterialTheme.shapes.medium) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSecondary)
            }
        }
    }
}