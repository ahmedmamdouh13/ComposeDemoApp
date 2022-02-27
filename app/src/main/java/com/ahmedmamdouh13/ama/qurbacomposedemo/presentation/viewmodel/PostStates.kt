package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel

import androidx.compose.runtime.MutableState
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Count

class PostStates {
    val like: ArrayList<MutableState<Boolean>> = arrayListOf()
    val likesCount: ArrayList<MutableState<Count>> = arrayListOf()
    val topCommentVisibility: ArrayList<MutableState<Boolean>> = arrayListOf()
    val topCommentLike: ArrayList<MutableState<Boolean>> = arrayListOf()
    val topCommentLikesCount: ArrayList<MutableState<Count>> = arrayListOf()
}