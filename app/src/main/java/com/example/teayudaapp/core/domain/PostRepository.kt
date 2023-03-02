package com.example.teayudaapp.core.domain

import android.util.Log
import com.example.teayudaapp.core.domain.model.PostType
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
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
                    Log.d("New post added","${post.id}")
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    suspend fun getPosts() : List<PostType> {
        var post = emptyList<PostType>()
        try {
            post = db.collection("posts").get().await().map {
                it.toObject(PostType::class.java)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return post
    }
}