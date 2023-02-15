package com.example.teayudaapp.homescreen.domain.model

import java.time.LocalDate

data class User(
    val id: Long,
    val name: String,
    val lastName: String,
    val userName: String,
    val imageUrl: String,
    val birthDate: LocalDate,
    val profileDescription: String,
    val gender: String,
    val createDate: LocalDate
)
