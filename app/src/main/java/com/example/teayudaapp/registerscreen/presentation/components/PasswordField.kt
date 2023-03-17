package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.example.teayudaapp.registerscreen.domain.SharedStringsResources

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordField(
    passwordText: String,
    onValueChange: (String) -> Unit,
    paddingValues: Dp,
    dataString: SharedStringsResources,
    colors: Color,
    modifier: Modifier = Modifier
) {
    val visibility = remember { mutableStateOf(true) }
    val visibilityIcon = if (visibility.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
    val transformation = if (visibility.value) PasswordVisualTransformation() else VisualTransformation.None
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = stringResource(id = dataString.passwordId),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Left
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordText,
                onValueChange = { onValueChange(it) },
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = transformation,
                maxLines = 1,
                singleLine = true,
                keyboardActions = KeyboardActions( onDone = {keyboardController?.hide()}),
                placeholder = { Text(
                    text = "contraseña",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSecondary) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Lock icon",
                        tint = MaterialTheme.colors.onSecondary
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { visibility.value = !visibility.value }) {
                        Icon(
                            imageVector = visibilityIcon,
                            contentDescription = "Password visibility",
                            tint = MaterialTheme.colors.onSecondary
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colors,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}