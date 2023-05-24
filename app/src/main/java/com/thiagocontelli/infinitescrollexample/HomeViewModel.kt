package com.thiagocontelli.infinitescrollexample

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    fun getAllPosts(): Flow<List<Post>> = flow {
        repository.getAllPosts().collect {
            emit(it)
        }
    }

}