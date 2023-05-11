package com.example.proguard.data.mappers

import com.example.proguard.data.dto.PostDto
import com.example.proguard.domain.model.PostModel

fun PostDto.toPostModel(): PostModel{
    return PostModel(
        body, id, title, userId
    )
}