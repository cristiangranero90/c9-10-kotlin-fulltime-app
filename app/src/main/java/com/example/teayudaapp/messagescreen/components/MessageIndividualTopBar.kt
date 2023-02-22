package com.example.teayudaapp.messagescreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.teayudaapp.R

@Composable
fun MessageIndividualTopBar(
    profileImage: String,
    profileName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier.height(128.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,

        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    //horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AsyncImage(
                        model = profileImage,
                        contentDescription = "Profile image",
                        modifier = Modifier.size(43.dp).clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        error = painterResource(id = R.drawable.home_material)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = profileName,
                        style = MaterialTheme.typography.body1,
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        },

        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Go back",
                    tint = MaterialTheme.colors.primary)
            }
        },
        actions = { Box(modifier = Modifier.width(70.dp)) }
    )

}

@Composable
@Preview
fun MessageIndividualTopBarPreview() {
    MessageIndividualTopBar("","Name of",{})
}