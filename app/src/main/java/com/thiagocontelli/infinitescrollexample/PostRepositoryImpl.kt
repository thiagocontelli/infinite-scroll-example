package com.thiagocontelli.infinitescrollexample

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val api: PostApi) : PostRepository {
    override fun getAllPosts(): List<Post> {
        api.getAllPosts().enqueue(object : Callback<GetAllPostsDTO> {
            override fun onResponse(
                call: Call<GetAllPostsDTO>, response: Response<GetAllPostsDTO>
            ) {
                if (response.body() != null) {
                    Log.d("PostRepositoryImpl", "onResponse: ${response.body()!!.posts.first().title}")
                }
            }

            override fun onFailure(call: Call<GetAllPostsDTO>, t: Throwable) {
                Log.d("PostRepositoryImpl", "onFailure: ${t.message}")
            }
        })

        return emptyList()
    }
}