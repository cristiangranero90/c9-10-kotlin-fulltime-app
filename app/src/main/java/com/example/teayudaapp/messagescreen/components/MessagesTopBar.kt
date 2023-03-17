package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessagesTopBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier.height(128.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,

        title = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Mensajes",
                    style = MaterialTheme.typography.body1,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Go back",
                    tint = MaterialTheme.colors.primary)
            }
        },
        actions = { Box(modifier = Modifier.width(70.dp))}
    )
}