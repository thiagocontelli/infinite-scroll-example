package com.thiagocontelli.infinitescrollexample

interface PostRepository {
    fun getAllPosts(): List<Post>
}