package com.example.teayudaapp.favouritesscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.core.domain.PostRepository
import com.example.teayudaapp.core.domain.UserRepository
import com.example.teayudaapp.core.domain.model.UserFirestore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val currentUser: FirebaseAuth
): ViewModel() {

    var state by mutableStateOf(FavouritesState())
        private set

    init {
        state= state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            state = state.copy(
                favouritesPost = postRepository.getFavouritesPost(currentUser.currentUser!!.uid),
                usersList = userRepository.getUsers()
            )
            state= state.copy(
                isLoading = false
            )
        }
    }

    fun getUser(userId: String) : UserFirestore? {
        var user: UserFirestore? = null
        state.usersList.forEach { it ->
            if (it.id == userId) {
                user = it
            }
        }
        return user
    }
    fun getCurrentUser() : FirebaseUser? {
        return currentUser.currentUser
    }


}