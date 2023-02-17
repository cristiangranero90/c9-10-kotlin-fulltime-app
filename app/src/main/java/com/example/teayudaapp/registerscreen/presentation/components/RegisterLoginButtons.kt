package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R

@Composable
fun RegisterLoginButtons(
    padding: Dp,
    isLogin: Boolean,
    onButtonClicked: (Boolean) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Box(
                modifier = Modifier.clickable { onButtonClicked(false) },
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(id = R.drawable.register_button),
                    contentDescription = "Register side",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(width = 80.dp, height = 31.dp)
                )
                Text(
                    text = "Registrar",
                    style = MaterialTheme.typography.body2,
                    color = if (!isLogin) MaterialTheme.colors.onSecondary else MaterialTheme.colors.primaryVariant
                )
            }

            Box(
                modifier = Modifier.clickable { onButtonClicked(true) },
                contentAlignment = Alignment.CenterStart
            ){
                Icon(
                    painter = painterResource(id = R.drawable.register_button),
                    contentDescription = "Loguin side",
                    tint = MaterialTheme.colors.background,
                    modifier = Modifier
                        .size(width = 80.dp, height = 31.dp)
                        .rotate(180f)
                        .offset(x = 21.dp, y = 0.dp)
                )
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.body2,
                    color = if (isLogin) MaterialTheme.colors.onSecondary else MaterialTheme.colors.primaryVariant
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterLoginButtonPreview(){
    RegisterLoginButtons(padding = 0.dp, isLogin = true, onButtonClicked = {})
}