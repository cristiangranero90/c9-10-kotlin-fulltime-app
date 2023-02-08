package com.example.teayudaapp.ui.composable.registerscreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ReportGmailerrorred
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teayudaapp.R


@Composable
fun RegisterScreen(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TittleView()
        }
        item {
            RegisterLoginButtons()
            Spacer(modifier = Modifier.height(11.dp))
        }

        item {
            EmailField()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            PasswordField()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            AgreeRadioButton()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            ContinueButton()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            Divider(Modifier.height(2.dp))
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            LoginGoogle()
            Spacer(modifier = Modifier.height(21.67.dp))
        }

        item {
            LoginFacebook()
            Spacer(modifier = Modifier.height(21.67.dp))
        }
    }
}

@Composable
private fun LoginFacebook() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
    ) {

        Text(
            text = "Iniciar sesion con Meta",
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun LoginGoogle() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
    ) {

        Text(
            text = "Iniciar sesion con Google",
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun ContinueButton() {
    Button(
        modifier = Modifier
            .width(282.dp)
            .height(45.dp),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFE5E0FF)
        )
    ) {

        Text(
            text = "Continuar",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
private fun AgreeRadioButton() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        RadioButton(
            selected = false,
            onClick = { },
            modifier = Modifier
                .size(14.dp)
        )

        Text(
            text = "Aceptar los terminos y condiciones",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun PasswordField() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Contraseña",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "password",
                onValueChange = { /*TODO: Password text field */ },
                shape = MaterialTheme.shapes.large,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Lock icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { /*TODO: Visibility*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "Password visibility"
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
private fun EmailField() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Email",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Left
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "email@email.com",
                onValueChange = { /*TODO: Email text field */ },
                shape = MaterialTheme.shapes.large,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email entry"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
private fun RegisterLoginButtons() {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Registrar")
            }
            Divider(
                modifier = Modifier
                    .height(30.dp)
                    .width(1.dp)
                    .background(Color.White)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
private fun TittleView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(174.dp)
            .background(MaterialTheme.colors.primary),
        Alignment.CenterStart,
    ) {
        Text(
            text = stringResource(id = R.string.app_tittle),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
fun RegisterScreenPreview() {
    RegisterScreen()
}