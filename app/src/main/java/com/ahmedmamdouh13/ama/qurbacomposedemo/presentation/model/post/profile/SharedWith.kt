package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.profile

data class SharedWith(
    val userId: Long,
    val postId: Long,
    val sharedWithName: String,
    val profileType: ProfileType,
    val isVerified: Boolean
)
