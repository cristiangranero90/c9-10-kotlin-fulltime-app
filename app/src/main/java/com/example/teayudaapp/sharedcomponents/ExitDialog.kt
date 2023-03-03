package com.example.teayudaapp.sharedcomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExitDialog(
    onDissmiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDissmiss() },
        title = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Top) {
                Text(text = "Quieres salir de la aplicacion?", style = MaterialTheme.typography.body1)
            }
        },
        confirmButton = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { onDissmiss() }, modifier = Modifier.width(150.dp)) {
                    Text(text = "Cancelar", style = MaterialTheme.typography.caption)
                }
                Button(onClick = { onConfirm() }, modifier = Modifier.width(150.dp)) {
                    Text(text = "Aceptar", style = MaterialTheme.typography.caption)
                }
            }
        },
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.primary,
        modifier = Modifier,
    )
}

@Composable
@Preview(showBackground = true)
fun ExitDialogPreview() {
    ExitDialog({},{})
}