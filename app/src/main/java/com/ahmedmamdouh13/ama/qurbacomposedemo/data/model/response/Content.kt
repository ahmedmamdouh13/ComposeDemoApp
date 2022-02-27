package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.response


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("sharedPost")
    val sharedPost: PostItem,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("promo")
    val promo: Promo,

    )