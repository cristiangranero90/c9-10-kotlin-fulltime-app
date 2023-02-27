package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.teayudaapp.R

@Composable
fun MessageItem(
    profileImageUrl: String,
    profileName: String,
    messageText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(53.dp)
            .clip(RoundedCornerShape(27.dp))
            .background(MaterialTheme.colors.primaryVariant)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AsyncImage(
                model = profileImageUrl,
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(43.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.home_material_1)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = profileName,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = messageText,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview()
fun MessageItemPreview(){
    MessageItem("", "No name", "Some messages to see", {})
}