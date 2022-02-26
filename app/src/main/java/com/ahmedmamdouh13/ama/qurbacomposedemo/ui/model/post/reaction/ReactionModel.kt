package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ReactionModel(val postId: Long,
                         val displayableCount: MutableState<String> = mutableStateOf(""),
                         val type: ReactionType,
                         val isLiked: MutableState<Boolean> = mutableStateOf(false),
)

