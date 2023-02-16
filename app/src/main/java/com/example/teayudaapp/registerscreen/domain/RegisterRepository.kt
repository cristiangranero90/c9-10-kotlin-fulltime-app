package com.example.teayudaapp.registerscreen.domain

import com.example.teayudaapp.registerscreen.data.local.UserRegister

interface RegisterRepository {

    suspend fun getAllUsers() : MutableList<UserRegister>

    suspend fun insertUser(toInsert: UserRegister)

}