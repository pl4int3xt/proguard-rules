package com.example.proguard.data.api

import com.example.proguard.data.dto.PostDto
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getAllPosts(): List<PostDto>
}