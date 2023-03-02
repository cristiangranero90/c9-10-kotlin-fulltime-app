package com.example.teayudaapp.core.di

import android.content.ContentValues
import android.provider.Settings.System.getString
import androidx.compose.ui.res.stringResource
import com.example.teayudaapp.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedModule {

    @Provides
    @Singleton
    fun provideAuthInstance() = Firebase.auth

    @Provides
    @Singleton
    fun provideGoogleSignIn() = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId("1083688185591-ktn50gpruvlvbfiqgv65il9alfao8gmt.apps.googleusercontent.com")
                .setFilterByAuthorizedAccounts(false)
                .build())
        .build()

    @Provides
    @Singleton
    fun provideGoogleOptions() = GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("1083688185591-ktn50gpruvlvbfiqgv65il9alfao8gmt.apps.googleusercontent.com")
        .requestEmail()
        .build()

}