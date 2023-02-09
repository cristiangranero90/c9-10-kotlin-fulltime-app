package com.example.teayudaapp.ui.composable.registerscreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonAgree(
    padding: Dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
    ) {
        RadioButton(
            selected = false,
            onClick = { },
            modifier = Modifier
                .size(24.dp)
        )

        Text(
            text = "Aceptar los terminos y condiciones",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}