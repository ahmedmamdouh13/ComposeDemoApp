package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.response


import com.google.gson.annotations.SerializedName

data class Reaction(
    @SerializedName("count")
    val count: Long,
    @SerializedName("isLiked")
    val isLiked: Boolean,
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("type")
    val type: String
)