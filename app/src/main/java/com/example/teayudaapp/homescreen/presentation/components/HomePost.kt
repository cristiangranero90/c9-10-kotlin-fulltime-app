package com.example.teayudaapp.homescreen.presentation.components

import android.text.format.DateFormat
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.time.LocalDate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomePost(
    textPost: String,
    imagePost: String?,
    voteUpCount: Int,
    voteDownCount: Int,
    modifier: Modifier = Modifier
) {
    val isExpanded = remember { mutableStateOf(false)}
    val inputColor = Color(0xFF01002E)
    val height = if (isExpanded.value || imagePost.isNullOrEmpty()) modifier.fillMaxSize() else modifier.height(216.dp)

    Card(
        onClick = { isExpanded.value = !isExpanded.value },
        shape = RoundedCornerShape(18.dp),
        modifier = height,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 5.dp)
                .fillMaxWidth()
        ) {
            //Post data
            HomePostTopData(imageUrl = null, name = "Some one", hashtag = "Hastag", date = LocalDate.now() , inputColor = inputColor)
            Spacer(modifier = Modifier.height(10.dp))
            HomePostData(imagePost, textPost)
        }
    }
}

@Composable
@Preview
fun HomePostPreview() {
    HomePost("So much text", null, 3, 1)
}