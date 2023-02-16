package com.example.teayudaapp.registerscreen.di

import android.content.Context
import androidx.room.Room
import com.example.teayudaapp.registerscreen.data.local.DbDataSource
import com.example.teayudaapp.registerscreen.data.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun dbDataSource(@ApplicationContext context: Context) : DbDataSource {
        return Room.databaseBuilder(context, DbDataSource::class.java, "users")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun userDao(db: DbDataSource) : UserDao = db.userDao()

}