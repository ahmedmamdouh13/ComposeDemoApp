package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post

import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo.PromoModel

data class PostContent(
    val type: ContentType,
    var text: String = "",
    var images: List<Int> = listOf(),
    var sharedPost: PostModel? = null,
    var promo: PromoModel? = null,
    var actionButtonText: String = ""
)
