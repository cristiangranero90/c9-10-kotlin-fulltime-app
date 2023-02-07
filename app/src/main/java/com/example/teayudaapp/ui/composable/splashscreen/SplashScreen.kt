package com.example.teayudaapp.ui.composable.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.teayudaapp.R
import com.example.teayudaapp.ui.composable.sharedcomponents.AnimatedDots


@Composable
fun SplashScreen(){
    //Simple splash screen Image, Text, AnimatedDots
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_material),
            contentDescription = "splash image")
        
        Text(text = stringResource(id = R.string.app_tittle) , style = MaterialTheme.typography.body1)

        //If loading... etc
        AnimatedDots()
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    SplashScreen()
}