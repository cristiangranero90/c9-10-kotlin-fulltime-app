package com.example.teayudaapp.postcreationscreen.presentation

data class PostCreationState(
    val error: Boolean = false,
    val realized: Boolean = false,
    val title: String = "",
    val description: String = "",
    val hashTag: String = "",
)