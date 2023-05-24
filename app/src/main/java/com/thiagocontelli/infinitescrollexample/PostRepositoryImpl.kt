package com.thiagocontelli.infinitescrollexample

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val api: PostApi) : PostRepository {
    override fun getAllPosts(): Flow<List<Post>> = flow {
        emit(api.getAllPosts().posts)
    }
}