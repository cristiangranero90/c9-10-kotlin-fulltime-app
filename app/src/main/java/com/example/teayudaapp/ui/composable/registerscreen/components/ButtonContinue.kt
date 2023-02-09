package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonContinue() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFE5E0FF)
        )
    ) {
        Text(
            text = "Continuar",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Continue action",
            tint = MaterialTheme.colors.primary
        )
    }
}