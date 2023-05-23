package com.thiagocontelli.infinitescrollexample

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    fun getAllPosts() {
        try {
            repository.getAllPosts()
        } catch (e: Exception) {
            Log.d("HomeViewModel", "getAllPosts: $e")
        }
    }

}