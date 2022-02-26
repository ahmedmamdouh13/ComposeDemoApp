package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile

import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Timestamp

open class PostProfileModel(
    val postId: Long,
    val userId: Long,
    val userName: String,
    val profilePicUrl: String,
    val timestamp: Timestamp,
    val profileType: ProfileType,
    var sharedWith: SharedWith? = null,
    val isVerified: Boolean
)