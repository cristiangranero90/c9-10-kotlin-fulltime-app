package com.example.teayudaapp.postcreationscreen.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PostField(
    mutableText: MutableState<String>,
    title: String,
    placeholderString: String,
    height: Dp,
    maxLines: Int,
    singleLine: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier){
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
            TextField(
                value = mutableText.value,
                onValueChange = { mutableText.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height),
                shape = MaterialTheme.shapes.large,
                maxLines = maxLines,
                singleLine = singleLine,
                textStyle = MaterialTheme.typography.body2,
                placeholder = {
                    Text(
                        text = placeholderString,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSecondary)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PostFieldPreview() {
    PostField(remember {
        mutableStateOf("")
    }, "Description", "Ej: Something", 49.dp, 10, true)
}