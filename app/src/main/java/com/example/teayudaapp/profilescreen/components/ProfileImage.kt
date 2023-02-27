package com.example.teayudaapp.profilescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileImage(
    name: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            AsyncImage(
                model = imageUrl,
                contentDescription = "Profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(146.dp)
                    .clip(shape = CircleShape),
                error = painterResource(id = com.example.teayudaapp.R.drawable.home_material_1)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ProfileImagePreview() {
    ProfileImage("Profile name", "https://via.placeholder.com/1000" )
}