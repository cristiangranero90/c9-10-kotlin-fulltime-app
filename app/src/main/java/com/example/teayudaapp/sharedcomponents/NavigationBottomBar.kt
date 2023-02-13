package com.example.teayudaapp.sharedcomponents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
){
    BottomNavigation(
        modifier = modifier.height(85.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.primary
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp) ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Go to home", modifier = Modifier.size(40.dp))
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp)) {
            Icon(painterResource(id = R.drawable.dice_material ), contentDescription = "Go to home", modifier = Modifier.size(30.dp))
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp)) {
            Icon(imageVector = Icons.Default.Message, contentDescription = "Go to home", modifier = Modifier.size(40.dp))
        }
        IconButton(onClick = { /*TODO*/ } , modifier = Modifier.size(80.dp)) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Go to home", modifier = Modifier.size(40.dp))
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BottomBarPreview(){
    BottomBar()
}