package com.example.proguard.domain.repository

import com.example.proguard.data.dto.PostDto

interface PostRepository {
    suspend fun getAllPosts(): List<PostDto>
}