package com.example.teayudaapp.registerscreen.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teayudaapp.R
import com.example.teayudaapp.registerscreen.domain.SharedStringsResources
import com.example.teayudaapp.registerscreen.presentation.components.*
import com.example.teayudaapp.sharedcomponents.LoadingDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun RegisterScreen(
    loginSuccess: () -> Unit,
    viewModel: RegisterScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    val homeState = viewModel.state
    val context = LocalContext.current
    val largeSpacer = 21.67.dp
    val smallSpacer = 11.dp
    val colorsBackground = if (viewModel.state.loginScreen) MaterialTheme.colors.primary else MaterialTheme.colors.background
    val colorsButton = if (viewModel.state.loginScreen) MaterialTheme.colors.background else MaterialTheme.colors.primary
    val padding = 6.dp
    //Mutable data of strings needed in the whole screen
    val dataString = if (viewModel.state.loginScreen) SharedStringsResources(
        emailId = R.string.login_email,
        passwordId = R.string.login_password,
        termsOrForgottenId = R.string.forgotten_password,
        registerButton = R.string.button_login)
    else SharedStringsResources(
        emailId = R.string.register_email,
        passwordId = R.string.register_password,
        termsOrForgottenId = R.string.app_terms,
        registerButton = R.string.button_register)

    val googleSignInClient = GoogleSignIn.getClient(context, viewModel.signInOptions)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val task =
            try {
                val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    .getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
                viewModel.auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            viewModel.googleSignIn()
                            Log.d("Init Session", "Google sign in")
                        }
                    }
            }
            catch (e: ApiException) {
                Log.w("TAG", "GoogleSign in Failed", e)
            }
    }

    LaunchedEffect(key1 = homeState.registerSuccess){
        if (homeState.registerSuccess && !homeState.isLoginYet) {
            Toast.makeText(context, "Usuario registrado con exito", Toast.LENGTH_SHORT).show()
            viewModel.changeRegister()
        }
        viewModel.changeRegister()
    }
    LaunchedEffect(key1 = homeState.onFailure){
        if (homeState.onFailure && !homeState.isLoginYet) {
            Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
            viewModel.changeError()
        }
        viewModel.changeError()
    }
    if (homeState.isLoginYet) {
        viewModel.changeLogin()
        Toast.makeText(context, "Iniciaste sesion como: ${viewModel.auth.currentUser!!.displayName ?: "No name" }", Toast.LENGTH_SHORT).show()
        loginSuccess()
    }
    if(homeState.isLoading){
        LoadingDialog()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorsBackground),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            TittleView(viewModel.state.loginScreen, colorsBackground)
        }
        item {
            RegisterLoginButtons(padding, viewModel.state.loginScreen) {
                viewModel.loginScreenSwitcher(it)
            }
            Spacer(modifier = Modifier.height(smallSpacer))
        }

        item {
            EmailField(homeState.emailText, { viewModel.onValueEmailChange(it) }, padding, dataString, colorsButton)
            Spacer(modifier = Modifier.height(largeSpacer))
        }

        item {
            PasswordField(homeState.passwordText, { viewModel.onValuePasswordChange(it)}, padding, dataString, colorsButton)
        }
        item {
            if (!homeState.loginScreen){
                Spacer(modifier = Modifier.height(largeSpacer))
                RadioButtonAgree(padding)
                Spacer(modifier = Modifier.height(largeSpacer))
            }
            else{
                ForgottenPassword(padding, dataString)
                Spacer(modifier = Modifier.height(largeSpacer))
            }
        }
        item {
            ButtonContinue { viewModel.onButtonContinuePressed() }
            Spacer(modifier = Modifier.height(largeSpacer))
        }

        item {
            Divider(
                Modifier
                    .height(2.dp)
                    .padding(start = padding, end = padding))
            Spacer(modifier = Modifier.height(largeSpacer))
        }

        item {
            ButtonLoginGoogle( {
                googleSignInClient.signOut()
                launcher.launch(googleSignInClient.signInIntent) },
                dataString,
                colorsButton)
            Spacer(modifier = Modifier.height(largeSpacer))
        }

        item {
            ButtonLoginFacebook(dataString, colorsButton)
            Spacer(modifier = Modifier.height(largeSpacer))
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
fun RegisterScreenPreview() {
    RegisterScreen({})
}