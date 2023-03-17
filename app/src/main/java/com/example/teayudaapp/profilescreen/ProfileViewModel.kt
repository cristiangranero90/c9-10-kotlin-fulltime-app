package com.example.teayudaapp.profilescreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.core.domain.UserRepository
import com.example.teayudaapp.core.domain.model.UserFirestore
import com.example.teayudaapp.profilescreen.model.ProfileState
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl,
    private val auth: FirebaseAuth,
    private val userRepository: UserRepository
): ViewModel() {
    private val user: FirebaseUser? = auth.currentUser
    var state by mutableStateOf(ProfileState())
        private set
    init {
        state = state.copy(
            profileName = user!!.displayName.toString(),
            profileImage = user!!.photoUrl.toString(),
            profileId = user!!.uid,
            isLogIn = auth.currentUser != null
        )
        userRepository.addNewUser(user = UserFirestore(
            id = user.uid,
            imageUrl = user.photoUrl.toString(),
            email = user.email.toString(),
            name = user.displayName.toString(),
            lastName = "",
            profileDescription = state.profileBio,
            gender = "",
            createDate = LocalDate.now().toString(),


        )
        )
        viewModelScope.launch {
            userRepository.getUsers().forEach() {
                Log.d("Name of users: ", "${it.id}")
            }
        }
    }
    fun changeEdit(biography: String) {
        val aux = !state.isEditable
        state = state.copy(
            isEditable = aux
        )
        if (!state.isEditable){
            state = state.copy(
                profileBio = biography
            )
        }
    }
    fun closeSession() {
        auth.signOut()
        state = state.copy(
            isLogIn = false
        )
    }

}