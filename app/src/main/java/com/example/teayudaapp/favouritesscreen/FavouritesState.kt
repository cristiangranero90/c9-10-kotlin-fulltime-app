package com.example.teayudaapp.favouritesscreen

import com.example.teayudaapp.core.domain.model.PostType
import com.example.teayudaapp.core.domain.model.UserFirestore

data class FavouritesState(
    val favouritesPost: List<PostType> = emptyList(),
    val usersList: List<UserFirestore> = emptyList(),
    val isLoading: Boolean = false,
)