package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Count

data class ReactionModel(val postId: Long,
                         val count: MutableState<Count> = mutableStateOf(0L),
                         val type: ReactionType,
                         val isLiked: MutableState<Boolean> = mutableStateOf(false),
)

