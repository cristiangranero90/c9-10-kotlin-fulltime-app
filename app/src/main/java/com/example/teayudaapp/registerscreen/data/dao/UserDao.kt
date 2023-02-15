package com.example.teayudaapp.registerscreen.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teayudaapp.registerscreen.data.local.UserRegister

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): Result<MutableList<UserRegister>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun postUser(user: UserRegister)
}