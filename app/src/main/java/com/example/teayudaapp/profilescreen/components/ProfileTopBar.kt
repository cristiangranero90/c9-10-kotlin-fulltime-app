package com.example.teayudaapp.profilescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teayudaapp.R

@Composable
fun ProfileTopBar(
    buttonEdit: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier.height(128.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(
                    text = "Perfil",
                    style = MaterialTheme.typography.body1,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
            }
        },
        navigationIcon = {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painterResource(id = R.drawable.home_material),
                contentDescription = "Go to home screen",
                modifier = Modifier.size(30.dp),
                tint = MaterialTheme.colors.primary)
        },
        actions = {
            IconButton(onClick = buttonEdit, enabled = false) {
                Icon(
                    painter = painterResource(id = R.drawable.edit_button),
                    contentDescription = "Profile side",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(39.dp)
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
        }
    )
}

@Composable
@Preview(showBackground = true)
fun ProfileTopBarPreview() {
    ProfileTopBar(buttonEdit = { /*TODO*/ })
}