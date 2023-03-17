package com.example.teayudaapp.registerscreen.presentation

import com.example.teayudaapp.registerscreen.data.local.UserRegister

data class RegisterState(
    val emailText: String = "",
    val passwordText: String = "",
    val loginScreen: Boolean = true,
    val isLoginYet: Boolean = false,
    val isLoading: Boolean = false,
    val onFailure: Boolean = false,
    val registerSuccess: Boolean = false,
    val users: List<UserRegister> = emptyList()
)
