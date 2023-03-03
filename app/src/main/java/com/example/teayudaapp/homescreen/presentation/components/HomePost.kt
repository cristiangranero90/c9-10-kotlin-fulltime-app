package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomePost(
    textPost: String,
    imagePost: String?,
    datePost: String,
    imageUser: String?,
    userName: String,
    hashTag: String,
    voteUpCount: Int,
    voteDownCount: Int,
    favouritePost: Boolean,
    modifier: Modifier = Modifier
) {
    val isExpanded = remember { mutableStateOf(false)}
    val inputColor = MaterialTheme.colors.onSecondary
    val cardHeight = if (isExpanded.value || imagePost.isNullOrEmpty()) modifier.fillMaxSize() else modifier.height(216.dp)
    val postHeight = if (isExpanded.value || imagePost.isNullOrEmpty()) modifier.fillMaxSize() else modifier.height(90.dp)

    Card(
        onClick = { isExpanded.value = !isExpanded.value },
        shape = RoundedCornerShape(18.dp),
        modifier = cardHeight,
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 5.dp)
                .fillMaxWidth()
        ) {
            //Post data
            HomePostTopData(imageUrl = imageUser, name = userName, hashtag = hashTag, date = datePost , inputColor = inputColor)

            Spacer(modifier = Modifier.height(10.dp))

            HomePostData(imagePost, textPost, modifier = postHeight)

            HomePostBottom(voteUpCount, voteDownCount, favouritePost)
        }
    }
}

@Composable
@Preview
fun HomePostPreview() {
    HomePost("So much text", null, "LocalDate.now()", null, "Some one", "#Favourite", 3, 1, true)
}