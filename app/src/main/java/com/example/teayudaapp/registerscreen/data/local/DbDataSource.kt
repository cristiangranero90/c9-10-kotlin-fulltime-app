package com.example.teayudaapp.registerscreen.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.teayudaapp.registerscreen.data.dao.UserDao

@Database(entities = [UserRegister::class], version = 1)
abstract class DbDataSource: RoomDatabase() {
    abstract fun userDao(): UserDao
}