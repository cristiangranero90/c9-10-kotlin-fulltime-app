package com.example.teayudaapp.registerscreen.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import com.example.teayudaapp.registerscreen.data.local.UserRegister
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl
): ViewModel() {
    //Firebase authorization
    private var auth: FirebaseAuth = Firebase.auth
    private var currentUser: FirebaseUser? = auth.currentUser
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
    private fun checkUser(){
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
}