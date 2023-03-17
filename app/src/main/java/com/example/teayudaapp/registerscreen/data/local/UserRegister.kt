package com.example.teayudaapp.registerscreen.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "users")
data class UserRegister(
    val email: String,
    val password: String,
    val name: String,
    val lastName: String,
    val imageUrl: String?,
    val profileDescription: String?,
    val gender: String?,
    val createDate: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
)