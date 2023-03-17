package com.example.teayudaapp.sharedcomponents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.teayudaapp.R

@Composable
fun BottomBar(
    onHomeClicked: () -> Unit,
    onRandomClicked: () -> Unit,
    onMessageClicked: () -> Unit,
    onFavouritesClicked: () -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
){

    BottomNavigation(
        modifier = modifier.height(85.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.primary,
    ) {

        BottomNavigationItem(
            selectedContentColor = Color(0xFF4B72FE),
            unselectedContentColor = Color(0xFF7286D3),
            selected = currentDestination?.hierarchy?.any { it.route == "home_screen"} == true,
            modifier = Modifier.padding(bottom = 10.dp, start = 15.dp),
            onClick = onHomeClicked,
            icon = {Icon(imageVector = Icons.Default.Home, contentDescription = "Go to home", modifier = Modifier.size(35.dp))},
            label = { Text(text = "Home", style = MaterialTheme.typography.body2, color = Color.Black, fontWeight = FontWeight.SemiBold)}
        )

        BottomNavigationItem(
            selectedContentColor = Color(0xFF4B72FE),
            unselectedContentColor = Color(0xFF7286D3),
            selected = currentDestination?.hierarchy?.any { it.route == "random_screen"} == true,
            modifier = Modifier.padding(bottom = 10.dp),
            onClick = onRandomClicked,
            icon = {Icon(painterResource(id = R.drawable.dice_material ), contentDescription = "Go to random", modifier = Modifier.size(28.dp))},
            label = { Text(text = "Random", style = MaterialTheme.typography.body2, color = Color.Black, fontWeight = FontWeight.SemiBold)}
        )

        BottomNavigationItem(
            unselectedContentColor = Color(0xFF7286D3),
            selectedContentColor = Color(0xFF4B72FE),
            selected = currentDestination?.hierarchy?.any { it.route == "message_screen"} == true,
            modifier = Modifier.padding(bottom = 10.dp),
            onClick = onMessageClicked,
            icon = {Icon(imageVector = Icons.Default.Message, contentDescription = "Go to messages", modifier = Modifier.size(35.dp))},
            label = { Text(text = "Mensajes", style = MaterialTheme.typography.body2, color = Color.Black, fontWeight = FontWeight.SemiBold)}
        )

        BottomNavigationItem(
            unselectedContentColor = Color(0xFF7286D3),
            selectedContentColor = Color(0xFF4B72FE),
            selected = currentDestination?.hierarchy?.any { it.route == "favourites_screen"} == true,
            modifier = Modifier.padding(bottom = 10.dp, end = 15.dp),
            onClick = onFavouritesClicked,
            icon = {Icon(imageVector = Icons.Default.Favorite, contentDescription = "Go to favourites", modifier = Modifier.size(35.dp))},
            label = { Text(text = "Favoritos", style = MaterialTheme.typography.body2, color = Color.Black, fontWeight = FontWeight.SemiBold)}
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BottomBarPreview(){
    BottomBar({},{},{},{}, currentDestination = NavDestination(""))
}