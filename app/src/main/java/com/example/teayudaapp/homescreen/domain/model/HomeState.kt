package com.example.teayudaapp.homescreen.domain.model

import com.example.teayudaapp.core.domain.model.PostType
import com.example.teayudaapp.core.domain.model.UserFirestore

data class HomeState(
    val searchText: String = "",
    val isLoading: Boolean = false,
    val posts: List<PostType> = emptyList(),
    val user: List<UserFirestore> = emptyList()
)
