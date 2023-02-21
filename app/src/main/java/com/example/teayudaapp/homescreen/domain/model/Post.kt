package com.example.teayudaapp.homescreen.domain.model

import java.time.LocalDate

data class Post(
    val id: Long,
    val title: String,
    val description: String,
    val likes: Int,
    val dislikes: Int,
    val shared: Int,
    val createdDate: LocalDate,
    val updateDate: LocalDate,
    val type: String,
    val userId: Long
)

data class PostGallery(
    val id: Long,
    val imageUrl: String,
    val tittle: String,
    val description: String,
    val potId: Long
)
