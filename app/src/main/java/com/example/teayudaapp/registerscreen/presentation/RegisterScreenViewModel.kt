package com.example.teayudaapp.registerscreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teayudaapp.homescreen.domain.model.User
import com.example.teayudaapp.registerscreen.data.dao.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val localData: UserDao
): ViewModel() {
    val users = emptyList<User>()

    init {
        viewModelScope.launch {
           localData.getAllUsers().onSuccess {
                users
           }

        }


    }

}