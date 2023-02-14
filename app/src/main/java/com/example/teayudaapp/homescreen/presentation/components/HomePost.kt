package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

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
            if(imagePost !=  null){
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    AsyncImage(
                        model = imagePost,
                        contentDescription = "Image post",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                }
            }
            Box(modifier = Modifier.fillMaxWidth()){
                Text(text = textPost, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
@Preview
fun HomePostPreview() {
    HomePost("So much text", null, 3, 1)
}