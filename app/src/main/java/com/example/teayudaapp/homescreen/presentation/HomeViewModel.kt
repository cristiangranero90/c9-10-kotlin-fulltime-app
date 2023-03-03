package com.example.teayudaapp.homescreen.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.core.domain.PostRepository
import com.example.teayudaapp.core.domain.UserRepository
import com.example.teayudaapp.core.domain.model.PostType
import com.example.teayudaapp.core.domain.model.UserFirestore
import com.example.teayudaapp.homescreen.domain.model.HomeState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postRepository: PostRepository,
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
                posts = postRepository.getPosts(),
                user = users.getUsers(),
                favouritesPost = postRepository.getFavouritesPost(currentUser.currentUser?.uid.toString())
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
            isRefreshing = true
        )
        viewModelScope.launch {
            state = state.copy(
                posts = postRepository.getPosts(),
                user = users.getUsers(),
                favouritesPost = postRepository.getFavouritesPost(currentUser.currentUser?.uid.toString())
            )
            state = state.copy(
                isRefreshing = false
            )
        }
    }
    fun isActiveUser() : Boolean {
        return currentUser.currentUser != null
    }

    fun showDialog() {
        val aux = state.showDialog
        state = state.copy(
            showDialog = !aux
        )
    }
    fun addToFavourites(postType: PostType) {
        if (!isFavourite(postType)) {
            postRepository.addPostToFavourites(postType, currentUser.currentUser?.uid.toString())
            reloadAll()
        }
    }

    fun isFavourite(postType: PostType): Boolean {
        var aux = false
        if (state.favouritesPost.isNotEmpty()){
            state.favouritesPost.forEach {
                aux = aux || it == postType
            }
        }
        return aux
    }
}