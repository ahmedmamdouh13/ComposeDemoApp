package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.response

import com.google.gson.annotations.SerializedName

data class SharedWith(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("sharedWithName")
    val sharedWithName: String,
    @SerializedName("profileType")
    val profileType: Int,
    @SerializedName("isVerified")
    val isVerified: Boolean
)
