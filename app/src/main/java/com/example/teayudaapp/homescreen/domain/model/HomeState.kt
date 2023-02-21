package com.example.teayudaapp.homescreen.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class HomeState(
    val searchText: MutableState<String> = mutableStateOf(""),
    val createText: MutableState<Boolean> = mutableStateOf(false)
)
