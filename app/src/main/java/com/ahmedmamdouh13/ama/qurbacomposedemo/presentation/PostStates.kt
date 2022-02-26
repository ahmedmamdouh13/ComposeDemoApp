package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Count

class PostStates {
    val like: ArrayList<MutableState<Boolean>> = arrayListOf()
    val likesCount: ArrayList<MutableState<Count>> = arrayListOf()
    val topCommentVisibility: ArrayList<MutableState<Boolean>> = arrayListOf()
    val topCommentLike: ArrayList<MutableState<Boolean>> = arrayListOf()
    val topCommentLikesCount: ArrayList<MutableState<Count>> = arrayListOf()
}