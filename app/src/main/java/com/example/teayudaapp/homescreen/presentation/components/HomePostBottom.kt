package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomePostBottom(
    voteCountUp: Int,
    voteCountDown: Int,
    favouritePost: Boolean,
    modifier: Modifier = Modifier
) {
    var favourite = if (favouritePost) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder
    val color = MaterialTheme.colors.primaryVariant

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.background,
            thickness = 1.dp
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Share with your friends")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Comment, "Post a comment below")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = favourite, contentDescription = "Add post to favourites")
            }

            Box(modifier = Modifier, contentAlignment = Alignment.CenterStart) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Like post")
                    }
                    Text(text = voteCountUp.toString(), style = MaterialTheme.typography.caption)

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Dislike post")
                    }
                    Text(text = voteCountDown.toString(), style = MaterialTheme.typography.caption)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomePostBottomPreview() {
    HomePostBottom(3, 1,false)
}