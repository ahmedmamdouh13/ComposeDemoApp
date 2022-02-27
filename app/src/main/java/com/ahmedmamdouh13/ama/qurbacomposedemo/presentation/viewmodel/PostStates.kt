package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Count

class PostStates {
    val postList: MutableState<List<PostModel>> = mutableStateOf(listOf())
    val like: ArrayList<MutableState<Boolean>> = arrayListOf()
    val likesCount: ArrayList<MutableState<Count>> = arrayListOf()
    val topCommentVisibility: ArrayList<MutableState<Boolean>> = arrayListOf()
    val topCommentLike: ArrayList<MutableState<Boolean>> = arrayListOf()
    val topCommentLikesCount: ArrayList<MutableState<Count>> = arrayListOf()
}