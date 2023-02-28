package com.example.teayudaapp.profilescreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.teayudaapp.profilescreen.model.ProfileState
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl,
    private val auth: FirebaseAuth
): ViewModel() {

    private val user: FirebaseUser? = auth.currentUser
    var state by mutableStateOf(ProfileState())
        private set

    init {
        state = state.copy(
            profileName = user!!.displayName.toString(),
            profileImage = user!!.photoUrl.toString(),
            profileId = user!!.uid,
        )
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
    }


}