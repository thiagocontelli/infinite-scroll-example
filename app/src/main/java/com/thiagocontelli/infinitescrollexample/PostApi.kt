package com.thiagocontelli.infinitescrollexample

import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    @GET("posts")
    suspend fun getAllPosts(
        @Query("skip") skip: Int? = 0
    ): GetAllPostsDTO
}