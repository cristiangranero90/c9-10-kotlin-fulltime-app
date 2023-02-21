package com.example.teayudaapp.registerscreen.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import com.example.teayudaapp.registerscreen.data.local.UserRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl
): ViewModel() {

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
        if(state.loginScreen){
            if (state.users.isNotEmpty()){
                state.users.forEach { user ->
                    if (user.email == state.emailText && user.password == state.passwordText){
                        state = state.copy(
                            isLoginYet = true
                        )
                    }
                }
                if (state.isLoginYet.not()){
                    state = state.copy(
                        onFailure = true
                    )
                }
            } else {
                state = state.copy(
                    onFailure = true
                )
            }
        } else {
            if (state.emailText.isNotBlank() && state.passwordText.isNotBlank()){
                viewModelScope.launch {
                    localData.insertUser(
                        UserRegister(state.emailText,
                            state.passwordText,
                            "",
                            "",
                            "",
                            "",
                            null,
                            LocalDate.now().toString() )
                    )
                    state= state.copy(
                        registerSuccess = true
                    )
                    reloadUsers()
                }
            }
            else{
                state = state.copy(onFailure = true)
            }
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