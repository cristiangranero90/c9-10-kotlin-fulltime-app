package com.example.teayudaapp.core.domain.model

data class UserFirestore(
    val id: String = "",
    val imageUrl: String = "",
    val email: String = "",
    val name: String = "",
    val lastName: String = "",
    val profileDescription: String? = "",
    val gender: String? = "",
    val createDate: String = ""
)
