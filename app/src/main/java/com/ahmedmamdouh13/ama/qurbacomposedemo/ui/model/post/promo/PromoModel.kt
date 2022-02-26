package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo

data class PromoModel(
    val postId: Long,
    val vendorId: Long,
    val vendorPic: String,
    val vendorPromoTitle: String,
    val vendorPromoSubtitle: String,
    val actionButtonText: String = "",
    val isActionNeeded: Boolean = false
)
