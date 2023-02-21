package com.example.teayudaapp.homescreen.presentation.components

import android.text.format.DateFormat
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.time.LocalDate
import java.util.Date


@Composable
fun HomePostTopData(
    imageUrl: String?,
    name: String,
    hashtag: String,
    date: LocalDate,
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
                            error = painterResource(com.example.teayudaapp.R.drawable.home_material),
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
                            color = inputColor,
                            fontWeight = FontWeight.Bold)
                        Text(text = date.toString(),
                            style = MaterialTheme.typography.body2,
                            fontSize = 8.sp,
                            color = inputColor)
                    }
                }
            }
            Text(text = hashtag,
                style = MaterialTheme.typography.body2,
                fontSize = 8.sp,
                color = inputColor,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePostTopDataPreview(){
    HomePostTopData(imageUrl = "https://via.placeholder.com/150" , name = "Some one", hashtag = "#work", date = LocalDate.now(), Color.Black)
}