package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.response


import com.google.gson.annotations.SerializedName

data class TopComment(
    @SerializedName("commentId")
    val commentId: Long,
    @SerializedName("commentText")
    val commentText: String,
    @SerializedName("isLiked")
    val isLiked: Boolean,
    @SerializedName("isVisible")
    val isVisible: Boolean,
    @SerializedName("likesCount")
    val likesCount: Long,
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("profilePicUrl")
    val profilePicUrl: String,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("userName")
    val userName: String
)