package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RegisterLoginButtons(
    padding: Dp,
    isLogin: Boolean,
    onButtonClicked: (Boolean) -> Unit
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
            Button(
                onClick = { onButtonClicked(false) },
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(
                    text = "Registrar",
                    style = MaterialTheme.typography.body2,
                    color = if (!isLogin) MaterialTheme.colors.onSecondary else Color.White)
            }
            Divider(
                modifier = Modifier
                    .height(30.dp)
                    .width(1.dp)
                    .background(Color.White)
            )
            Button(
                onClick = { onButtonClicked(true) },
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.body2,
                    color = if (isLogin) MaterialTheme.colors.onSecondary else Color.White)
            }
        }
    }
}