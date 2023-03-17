package com.example.teayudaapp.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.teayudaapp.R
import com.example.teayudaapp.sharedcomponents.AnimatedDots
import kotlinx.coroutines.*


@Composable
fun SplashScreen(
    navigate: () -> Unit,
) {

    var loading by remember { mutableStateOf(true) }
    val timeMilis = 3000L
    val scope = rememberCoroutineScope().coroutineContext

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
        
        Text(text = stringResource(id = R.string.app_tittle) ,
            style = MaterialTheme.typography.body1,
            color = Color(0xFFFFF2F2))

        //If loading... etc
        if (loading){
            AnimatedDots()
        } else {
            navigate()
        }
        LaunchedEffect(loading){
            if (loading){
                delay(timeMilis)
            }
            loading = !loading
        }
    }
}



@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    //SplashScreen()
}