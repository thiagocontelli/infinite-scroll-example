package com.thiagocontelli.infinitescrollexample

import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getAllPosts(): GetAllPostsDTO
}