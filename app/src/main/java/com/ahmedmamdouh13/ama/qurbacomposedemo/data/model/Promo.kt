package com.ahmedmamdouh13.ama.qurbacomposedemo.data.model


import com.google.gson.annotations.SerializedName

data class Promo(
    @SerializedName("actionButtonText")
    val actionButtonText: String,
    @SerializedName("isActionNeeded")
    val isActionNeeded: Boolean,
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("vendorId")
    val vendorId: Long,
    @SerializedName("vendorPic")
    val vendorPic: String,
    @SerializedName("vendorPromoSubtitle")
    val vendorPromoSubtitle: String,
    @SerializedName("vendorPromoTitle")
    val vendorPromoTitle: String
)