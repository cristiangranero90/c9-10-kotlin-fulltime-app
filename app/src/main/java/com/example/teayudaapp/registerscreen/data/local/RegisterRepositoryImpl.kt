package com.example.teayudaapp.registerscreen.data.local

import com.example.teayudaapp.registerscreen.data.dao.UserDao
import com.example.teayudaapp.registerscreen.domain.RegisterRepository
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val localDataSource: UserDao
): RegisterRepository {

    override suspend fun getUsers(): Result<MutableList<UserRegister>> {
        return localDataSource.getAllUsers()
    }

    override suspend fun insertUser(toInsert: UserRegister) {
        localDataSource.postUser(toInsert)
    }
}