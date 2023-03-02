package com.example.teayudaapp.core.domain.model

import java.time.LocalDate

data class PostType(
    val id: String,
    val imageUrl: String?,
    val createDate: LocalDate,
    val postData: String,
    val upVote: Int,
    val downVote: Int,
    val userId: String,
    val comments: List<Comments>,
)
