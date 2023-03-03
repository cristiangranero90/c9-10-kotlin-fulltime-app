package com.example.teayudaapp.core.domain.model

data class PostType(
    val id: String = "",
    val imageUrl: String? = "",
    val createDate: String = "",
    val postData: String = "",
    val title: String = "",
    val hashTag: String? = "",
    val upVote: Int = 0,
    val downVote: Int = 0,
    val userId: String = "",
    val comments: List<Comments> = emptyList(),
)
