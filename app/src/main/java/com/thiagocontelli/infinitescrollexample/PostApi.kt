package com.thiagocontelli.infinitescrollexample

import retrofit2.Call
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    fun getAllPosts(): Call<GetAllPostsDTO>
}