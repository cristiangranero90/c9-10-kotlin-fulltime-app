package com.example.teayudaapp.profilescreen.model

import com.example.teayudaapp.homescreen.domain.model.Post
import java.time.LocalDate

data class ProfileState(
    var profileId: String = "",
    var profileImage: String? = null,
    var profileName: String = "no name",
    var profileBio: String = "No biography yet",
    var profileDate: LocalDate = LocalDate.now(),
    var isEditable: Boolean = false,
    var isLoading: Boolean = false,
    val post: List<Post> = emptyList(),

    )
