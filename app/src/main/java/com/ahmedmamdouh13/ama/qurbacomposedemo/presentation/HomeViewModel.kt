package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.local.DataSource
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.mapper.toPostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    private val postStates: PostStates = PostStates()

    private val _postsLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()
    val postsLiveData: LiveData<List<PostModel>> = _postsLiveData

    fun getAllPosts(context: Context) {
        viewModelScope.launch {
            DataSource.getAllPosts(context).collect { posts ->
                _postsLiveData.value = posts.map { it.toPostModel(postStates) }
            }
        }
    }


}

