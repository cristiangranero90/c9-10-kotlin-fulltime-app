package com.example.teayudaapp.homescreen.domain.model

sealed interface HomeFilter {
    object News: HomeFilter
    object Top: HomeFilter
    object Trends: HomeFilter
}
