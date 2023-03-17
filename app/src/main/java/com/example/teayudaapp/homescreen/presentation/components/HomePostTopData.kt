package com.example.teayudaapp.homescreen.presentation.components

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
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.time.LocalDate
@Composable
fun HomePostTopData(
    imageUrl: String?,
    name: String,
    hashtag: String,
    date: String,
    inputColor: Color,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxWidth()) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            //Image view
            Box(modifier = Modifier, contentAlignment = Alignment.Center){
                Row(modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                        AsyncImage(
                            model = imageUrl,
                            contentDescription = "Profile of the post",
                            error = painterResource(com.example.teayudaapp.R.drawable.home_material_1),
                            modifier = Modifier
                                .size(33.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop)

                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(start = 8.dp))
                    {
                        Text(text = name,
                            style = MaterialTheme.typography.body2,
                            fontSize = 8.sp,
                            color = MaterialTheme.colors.onSecondary,
                            fontWeight = FontWeight.Medium
                        )
                        Text(text = date.toString(),
                            style = MaterialTheme.typography.body2,
                            fontSize = 8.sp,
                            color = Color(0xFF262763),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            Text(
                text = hashtag,
                style = MaterialTheme.typography.body2,
                fontSize = 8.sp,
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePostTopDataPreview(){
    HomePostTopData(imageUrl = "https://via.placeholder.com/150" , name = "Some one", hashtag = "#work", date = "LocalDate", Color.Black)
}