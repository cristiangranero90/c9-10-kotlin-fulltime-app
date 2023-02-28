package com.example.teayudaapp.core.domain.model

import com.example.teayudaapp.homescreen.domain.model.User
import java.time.LocalDate

data class PostType(
    val id: Long,
    val imageUrl: String,
    val createDate: LocalDate,
    val postString: String,
    val upVote: Int,
    val downVote: Int,
    val user: User,
    val comments: List<Comments>,
)
