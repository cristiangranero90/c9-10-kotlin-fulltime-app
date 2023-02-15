package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun HomePostData(
    imageUrl: String?,
    textOfPost: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            if (imageUrl.isNullOrBlank().not()){
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "image of the post",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center)
            }
        }
    }
    Text(text = textOfPost, style = MaterialTheme.typography.caption, fontWeight = FontWeight.Bold )
}

@Composable
@Preview(showBackground = false)
fun HomePostDataPreview(){
    HomePostData("https://via.placeholder.com/1250", "Something to show")
}
