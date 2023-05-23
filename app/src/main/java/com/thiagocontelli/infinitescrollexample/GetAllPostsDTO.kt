package com.thiagocontelli.infinitescrollexample

data class GetAllPostsDTO(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)