package com.thiagocontelli.infinitescrollexample

import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getAllPosts(): Flow<List<Post>>
}