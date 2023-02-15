package com.example.teayudaapp.registerscreen.domain

import com.example.teayudaapp.registerscreen.data.local.UserRegister

interface RegisterRepository {

    suspend fun getUsers(): Result<MutableList<UserRegister>>

    suspend fun insertUser(toInsert: UserRegister)

}