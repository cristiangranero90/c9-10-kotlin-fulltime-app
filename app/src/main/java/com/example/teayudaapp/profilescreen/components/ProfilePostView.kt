package com.example.teayudaapp.profilescreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.teayudaapp.homescreen.presentation.components.HomePostTopData
import java.time.LocalDate

@Composable
fun ProfilePostView(
    userImage: String,
    userName: String,
    date: String,
    postText: String,
    postImage: String?,
    hashtag: String,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(18f))
            .border(width = 1.dp, color = Color.White)
            .padding(10.dp)
    ){
       Column(
           modifier = Modifier.fillMaxWidth(),
           verticalArrangement = Arrangement.SpaceAround,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           HomePostTopData(
               imageUrl = userImage,
               name = userName,
               hashtag = hashtag,
               date = date,
               inputColor = Color.Black
           )
           if (postImage != null){
               AsyncImage(model = postImage, contentDescription = "Image of the post")
           }
           Text(text = postText, style = MaterialTheme.typography.caption)
       }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePostViewPreview(){
    ProfilePostView(
        userImage = "https://via.placeholder.com/200",
        userName = "Profile Name",
        date = "LocalDate.now()",
        postText = "Something to post",
        postImage = "https://via.placeholder.com/1000",
        hashtag = "#GoGo",
    )
}