package com.example.proguard.data.repository

import com.example.proguard.data.api.Api
import com.example.proguard.data.dto.PostDto
import com.example.proguard.domain.repository.PostRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: Api
): PostRepository {
    override suspend fun getAllPosts(): List<PostDto> {
        return api.getAllPosts()
    }
}