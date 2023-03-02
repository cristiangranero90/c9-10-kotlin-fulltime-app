package com.example.teayudaapp.profilescreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.teayudaapp.Hilt_MainActivity
import com.example.teayudaapp.profilescreen.model.ProfileState
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl,
    private val auth: FirebaseAuth,
    private val gso: GoogleSignInOptions
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