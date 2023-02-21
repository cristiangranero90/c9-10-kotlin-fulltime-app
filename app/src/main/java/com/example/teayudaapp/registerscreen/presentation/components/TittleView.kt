package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun TittleView(
    isLogin: Boolean,
    colors: Color
) {
    var imageResource = if (isLogin) R.drawable.dark_blue_login else R.drawable.light_blue_register

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(174.dp),
        Alignment.CenterStart,
    ) {

        Image(
            painterResource(id = imageResource),
            contentDescription = "Title blue image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(800.dp)
        )
        Text(
            text = stringResource(id = R.string.app_tittle),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSecondary
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(16.dp)
                .absoluteOffset(y = 55.dp)
                .rotate(175f),
            color = colors
        )
    }
}