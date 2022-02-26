package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model


import com.google.gson.annotations.SerializedName

data class PostItem(
    @SerializedName("content")
    val content: List<Content>,
    @SerializedName("profile")
    val profile: Profile,
    @SerializedName("reactions")
    val reactions: List<Reaction>,
    @SerializedName("topComment")
    val topComment: TopComment
)