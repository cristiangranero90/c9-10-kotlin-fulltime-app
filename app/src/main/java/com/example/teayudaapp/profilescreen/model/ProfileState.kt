package com.example.teayudaapp.profilescreen.model

import com.example.teayudaapp.homescreen.domain.model.Post
import java.time.LocalDate

data class ProfileState(
    val profileId: Long = 0,
    val profileImage: String? = null,
    val profileBio: String = "No biography yet",
    val profileDate: LocalDate = LocalDate.now(),
    val isEditable: Boolean = false,
    val isLoading: Boolean = false,
    val post: List<Post> = emptyList(),

    )
