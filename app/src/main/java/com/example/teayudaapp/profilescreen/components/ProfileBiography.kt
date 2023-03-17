package com.example.teayudaapp.profilescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun ProfileBiography(
    biography: MutableState<String>,
    isEditable: Boolean,
    createdDate: LocalDate,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(18f),
                color = Color.White
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = biography.value,
                onValueChange = { biography.value = it },
                modifier = Modifier.fillMaxWidth(),
                readOnly = isEditable,
                textStyle = MaterialTheme.typography.caption,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 2.dp)
                .height(1.dp)
                .background(color = Color.White))

            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(18f)
                    )
                    .padding(6.dp)

            ) {
                Column() {
                    Text(text = "Creado el", style = MaterialTheme.typography.caption)
                    Text(text = createdDate.toString(), style = MaterialTheme.typography.caption)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileBiographyPreview() {
    val bio = remember {
        mutableStateOf("something to write")
    }
    ProfileBiography(bio, false, LocalDate.now())
}