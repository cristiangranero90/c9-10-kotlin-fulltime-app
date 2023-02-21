package com.example.teayudaapp.homescreen.domain.model

sealed class HomeFilter {
    object News: HomeFilter()
    object Top: HomeFilter()
    object Trends: HomeFilter()
}
