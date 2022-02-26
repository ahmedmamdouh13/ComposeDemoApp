package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("isVerified")
    val isVerified: Boolean,
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("profilePicUrl")
    val profilePicUrl: String,
    @SerializedName("profileType")
    val profileType: Int,
    @SerializedName("sharedWith")
    val sharedWith: Boolean,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("userName")
    val userName: String
)