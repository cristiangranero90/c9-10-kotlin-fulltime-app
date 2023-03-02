package com.example.teayudaapp.core.domain

import android.util.Log
import com.example.teayudaapp.core.domain.model.UserFirestore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val db: FirebaseFirestore
){
    fun addNewUser(user: UserFirestore) {
        try {
            db.collection("users").document("${user.id}").set(user)
                .addOnSuccessListener {
                    Log.d("User SUCCESS:", "New user added")
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun aux(user: UserFirestore) {
        try {
            db.collection("users").document("${user.id}").collection("messages").get()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getUsers() : List<UserFirestore> {
        var users = emptyList<UserFirestore>()
        try {
            users = db.collection("users").get().await().map {
                it.toObject(UserFirestore::class.java)
                }
            } catch (e: Exception){
             e.printStackTrace()
            }
        return users
    }
}