package com.example.proguard.domain.use_case

import com.example.proguard.common.Resource
import com.example.proguard.data.mappers.toPostModel
import com.example.proguard.domain.model.PostModel
import com.example.proguard.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(): Flow<Resource<List<PostModel>>> = flow {
        try {
            emit(Resource.Loading())
            val posts = repository.getAllPosts().map { it.toPostModel() }
            emit(Resource.Success(posts))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "unknown error"))
        } catch (e: IOException){
            emit(Resource.Error("network error"))
        }
    }
}