package com.example.proguard.presentation.main

import com.example.proguard.domain.model.PostModel

data class MainViewState(
    val isLoading: Boolean = false,
    val message: String = "",
    val posts: List<PostModel>? = emptyList()
)