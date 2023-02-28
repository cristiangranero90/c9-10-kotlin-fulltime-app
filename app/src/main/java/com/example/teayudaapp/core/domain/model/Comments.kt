package com.example.teayudaapp.core.domain.model

import com.example.teayudaapp.homescreen.domain.model.User
import java.time.LocalDate

data class Comments(
    val name: String,
    val profileUrl: String,
    val comment: String,
    val date: LocalDate,
    val user: User,
)
