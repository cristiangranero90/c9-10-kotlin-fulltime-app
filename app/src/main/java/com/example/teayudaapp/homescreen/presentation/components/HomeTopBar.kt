package com.example.teayudaapp.homescreen.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeTopBar(
    searchText: MutableState<String>,
    modifier: Modifier = Modifier
){
    TopAppBar(
        modifier = modifier.height(128.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            TextField(
                value = searchText.value,
                onValueChange = { searchText.value = it },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.height(47.dp),
                maxLines = 1,
                singleLine = true,
                textStyle = TextStyle(fontSize = 12.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                placeholder = { Text(
                    text = stringResource(id = com.example.teayudaapp.R.string.search_placeholder),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF262763)) },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search space",
                        tint = Color(0xFF262763)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            ) },
        navigationIcon = {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painterResource(id = com.example.teayudaapp.R.drawable.home_material),
                contentDescription = "Go to home screen",
                modifier = Modifier.size(30.dp),
                tint = MaterialTheme.colors.primary)
                         },
        actions = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile side",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.size(39.dp))
            Spacer(modifier = Modifier.size(5.dp))
        }
    )
}

@Composable
@Preview(showBackground = true)
fun HomeTopBarPreview(){
    val text = remember { mutableStateOf("Something") }
    HomeTopBar( text )
}