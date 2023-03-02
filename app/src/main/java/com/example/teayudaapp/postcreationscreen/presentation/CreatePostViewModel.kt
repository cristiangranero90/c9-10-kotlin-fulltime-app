package com.example.teayudaapp.postcreationscreen.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.teayudaapp.core.domain.PostRepository
import com.example.teayudaapp.core.domain.model.PostType
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val postRepository: PostRepository,
    private val currentUser: FirebaseAuth
): ViewModel() {

    var state by mutableStateOf(PostCreationState())
        private set

    fun addPost(title: String, description: String, hashTag: String) {
        state = state.copy(
            title = title,
            description = description,
            hashTag = hashTag
        )
        if (state.title.isNotBlank() && state.description.isNotBlank() && state.hashTag.isNotBlank())
        {
            postRepository.addPost(
                PostType(
                    id = "",
                    imageUrl = "https://via.placeholder.com/800",
                    createDate = LocalDate.now().toString(),
                    postData = state.description,
                    upVote = 0,
                    downVote = 0,
                    userId = currentUser.uid.toString(),
                    comments = emptyList(),
                    title = state.title,
                    hashTag = state.hashTag
                )
            )
            state = state.copy(
                realized = true
            )
        }
        else{
            state = state.copy(
                error = true
            )
        }
    }

    fun changeRealized() {
        state = state.copy(
            realized = false
        )
    }
}