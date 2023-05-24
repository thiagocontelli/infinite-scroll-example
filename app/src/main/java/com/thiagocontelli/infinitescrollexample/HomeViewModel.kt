package com.thiagocontelli.infinitescrollexample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    fun getAllPosts() {
        viewModelScope.launch {
            repository.getAllPosts()
                .catch {
                    Log.d("HomeViewModel", "getAllPosts: ${it.message}")
                }
                .collect {
                    Log.d("HomeViewModel", "getAllPosts: ${it.first().title}")
                }
        }
    }

}