package com.example.teayudaapp.core.domain.model

import com.example.teayudaapp.homescreen.domain.model.User
import java.time.LocalDate

data class Message(
    val id: String,
    val createDate: LocalDate,
    val senderUser: User,
    val toUser: User,
    val message: String,
)
