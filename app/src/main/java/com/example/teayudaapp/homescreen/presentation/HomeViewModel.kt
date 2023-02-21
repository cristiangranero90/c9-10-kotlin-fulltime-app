package com.example.teayudaapp.homescreen.presentation

import androidx.lifecycle.ViewModel
import com.example.teayudaapp.homescreen.domain.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    //TODO: Local data
): ViewModel() {

    val state = HomeState()

}