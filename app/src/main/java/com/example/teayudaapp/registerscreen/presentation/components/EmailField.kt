package com.example.teayudaapp.registerscreen.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.example.teayudaapp.registerscreen.domain.SharedStringsResources

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EmailField(
    emailText: MutableState<String>,
    paddingValues: Dp,
    dataString: SharedStringsResources,
    colors: Color,
    modifier: Modifier = Modifier,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = dataString.emailId),
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Left
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailText.value,
                onValueChange = { emailText.value = it },
                shape = MaterialTheme.shapes.large,
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                keyboardActions = KeyboardActions( onDone = { keyboardController?.hide() }),
                placeholder = { Text(
                    text = "email@example.com",
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSecondary) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email entry",
                        tint = MaterialTheme.colors.onSecondary
                    )
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