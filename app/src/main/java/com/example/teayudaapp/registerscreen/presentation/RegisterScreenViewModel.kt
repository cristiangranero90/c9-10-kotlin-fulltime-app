package com.example.teayudaapp.registerscreen.presentation

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.signin.SignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl,
    val auth: FirebaseAuth,
    val signInOptions: GoogleSignInOptions
): ViewModel() {
    //Firebase authorization
    //private val auth: FirebaseAuth = Firebase.auth
    private val currentUser: FirebaseUser? = auth.currentUser
    var state by mutableStateOf(RegisterState())
        private set
    init {
        viewModelScope.launch {
           state = state.copy(
               isLoading = true,
               onFailure = false
           )
            state = state.copy(
                users = localData.getAllUsers()
            )
            state = state.copy(
                isLoading = false
            )
            //Check if the user is already logged
            checkUser()
        }
    }
    private fun sendConfirmation() {
        currentUser?.sendEmailVerification()
    }
    private fun reloadUsers(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                onFailure = false
            )
            state = state.copy(
                users = localData.getAllUsers()
            )
            state = state.copy(
                isLoading = false
            )
        }
    }
    fun checkUser(){
        if (currentUser != null){
            state = state.copy(
                isLoginYet = true
            )
        }
    }
    fun onValueEmailChange(text: String){
        state = state.copy(
            emailText = text
        )
    }
    fun onValuePasswordChange(text: String){
        state = state.copy(
            passwordText = text
        )
    }
    fun loginScreenSwitcher(switch: Boolean){
        state = state.copy(
            loginScreen = switch
        )
    }
    fun onButtonContinuePressed(){
        //On login
        if(
            state.loginScreen &&
            !state.passwordText.isNullOrEmpty() &&
            !state.emailText.isNullOrEmpty() &&
            currentUser == null)
        {
            auth.signInWithEmailAndPassword(state.emailText, state.passwordText)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful){
                        state = state.copy(
                            isLoginYet = true
                        )
                    }
                    else{
                        Log.d("Exception!!: ",task.exception.toString())
                        state = state.copy(
                            onFailure = true
                        )
                    }
                }
        }
        //On register
        else if (
            !state.loginScreen &&
            !state.emailText.isNullOrEmpty() &&
            !state.passwordText.isNullOrEmpty() &&
            currentUser == null)
        {
            auth.createUserWithEmailAndPassword(state.emailText, state.passwordText)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        state = state.copy(
                            registerSuccess = true,
                            isLoginYet = true
                        )
                        sendConfirmation()
                    }
                    else{
                        Log.d("Exception!!: ",task.exception.toString())
                        state = state.copy(
                            onFailure = true
                        )
                    }
                }
        }
        //On failure
        else {
            Log.d("Error", "Unknown error: Firebase detail ${currentUser.toString()}")
            state = state.copy(
                onFailure = true
            )
        }
    }
    fun changeRegister() {
        state = state.copy(
            registerSuccess = false
        )
    }
    fun changeLogin() {
        state = state.copy(
            isLoginYet = false
        )
    }
    fun changeError() {
        state = state.copy(
            onFailure = false
        )
    }
    fun googleSignIn() {
        state = state.copy(
            isLoginYet = true
        )
    }
}