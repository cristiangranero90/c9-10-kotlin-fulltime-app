package com.example.teayudaapp.favouritesscreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun NoFavouritesAdded(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painterResource(
                id = R.drawable.no_favourites)
                , contentDescription = "No favourites"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "¡Aun no has agregado ninguna\n publicacion a favoritos!",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun NoFavouritesAddedPreview() {
    NoFavouritesAdded()
}