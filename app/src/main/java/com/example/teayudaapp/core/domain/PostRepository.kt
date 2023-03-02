package com.example.teayudaapp.core.domain

import android.util.Log
import com.example.teayudaapp.core.domain.model.PostType
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(
    private val db: FirebaseFirestore
){

    fun addPost(post: PostType) {
        try {
            db.collection("posts").add(post)
                .addOnSuccessListener{
                    Log.d("","${post.id}")
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}