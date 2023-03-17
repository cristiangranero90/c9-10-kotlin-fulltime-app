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
    onFavouritesClicked: () -> Unit,
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
            modifier = modifier.fillMaxWidth().padding(end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Share with your friends", tint = color)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Comment, "Post a comment below", tint = color)
            }
            IconButton(onClick = { onFavouritesClicked() }) {
                Icon(imageVector = favourite, contentDescription = "Add post to favourites", tint = color)
            }

            Box(modifier = Modifier, contentAlignment = Alignment.CenterStart) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Box(modifier = Modifier){
                       Row(
                           modifier = Modifier,
                       //horizontalArrangement = Arrangement.spacedBy(0.dp),
                       verticalAlignment = Alignment.CenterVertically
                       ) {
                           IconButton(onClick = { /*TODO*/ }) {
                               Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Like post", tint = color)
                           }
                           Text(text = voteCountUp.toString(), style = MaterialTheme.typography.caption, color = color)
                       }
                    }
                    Box(modifier = Modifier){
                        Row(
                            modifier = Modifier,
                            //horizontalArrangement = Arrangement.spacedBy(0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Dislike post", tint = color)
                            }
                            Text(text = voteCountDown.toString(), style = MaterialTheme.typography.caption, color = color)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomePostBottomPreview() {
    HomePostBottom({},3, 1,false)
}