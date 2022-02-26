package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.comment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Count
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Timestamp

data class CommentModel(
    val commentId: Long,
    val postId: Long,
    val userName: String,
    val profilePicUrl: String,
    val likesCount:  MutableState<Count>  = mutableStateOf(0L),
    val timestamp: Timestamp,
    val commentText: String,
    val isLiked: MutableState<Boolean> = mutableStateOf(false),
    val isVisible:  MutableState<Boolean>  = mutableStateOf(false),
    )
