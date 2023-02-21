package com.example.teayudaapp.profilescreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.teayudaapp.profilescreen.model.ProfileState
import com.example.teayudaapp.registerscreen.data.local.RegisterRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val localData: RegisterRepositoryImpl
): ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set


}