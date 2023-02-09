package com.example.teayudaapp.ui.composable.registerscreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R
import com.example.teayudaapp.ui.composable.registerscreen.components.*


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
){
    var emailText = remember { mutableStateOf("") }
    var passwordText = remember { mutableStateOf("") }
    val padding = 6.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            TittleView()
        }
        item {
            RegisterLoginButtons(padding)
            Spacer(modifier = Modifier.height(11.dp))
        }

        item {
            EmailField(emailText, padding)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            PasswordField(passwordText, padding)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            RadioButtonAgree(padding)
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ButtonContinue()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            Divider(Modifier
                .height(2.dp)
                .padding(start = padding, end = padding))
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ButtonLoginGoogle()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ButtonLoginFacebook()
            Spacer(modifier = Modifier.height(21.67.dp))
        }
    }
}

















@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
fun RegisterScreenPreview() {
    RegisterScreen()
}