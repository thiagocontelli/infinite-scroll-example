package com.thiagocontelli.infinitescrollexample

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val api: PostApi) : PostRepository {
    override fun getAllPosts(skip: Int): Flow<GetAllPostsDTO> = flow {
        emit(api.getAllPosts(skip))
    }
}