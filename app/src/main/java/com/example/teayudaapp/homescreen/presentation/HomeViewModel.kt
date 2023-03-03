package com.example.teayudaapp.homescreen.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.core.domain.PostRepository
import com.example.teayudaapp.core.domain.UserRepository
import com.example.teayudaapp.core.domain.model.UserFirestore
import com.example.teayudaapp.homescreen.domain.model.HomeState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PostRepository,
    private val users: UserRepository,
    private val currentUser: FirebaseAuth
): ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            state = state.copy(
                posts = repository.getPosts(),
                user = users.getUsers()
            )
            state = state.copy(
                isLoading = false
            )
        }
    }

    fun getUser(userId: String) : UserFirestore? {
        var user: UserFirestore? = null
        state.user.forEach { it ->
            if (it.id == userId) {
                user = it
            }
        }
        return user
    }
    fun getOwnImage() : String {
        return currentUser.currentUser?.photoUrl.toString()
    }

    fun reloadAll() {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            state = state.copy(
                posts = repository.getPosts(),
                user = users.getUsers()
            )
            state = state.copy(
                isLoading = false
            )
        }
    }

}