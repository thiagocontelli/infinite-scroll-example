package com.thiagocontelli.infinitescrollexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private var _totalPosts = MutableLiveData<Int>()
    val totalPosts: LiveData<Int>
        get() = _totalPosts

    fun getAllPosts(skip: Int): Flow<List<Post>> = flow {
        repository.getAllPosts(skip).collect {
            _totalPosts.value = it.total
            emit(it.posts)
        }
    }

}