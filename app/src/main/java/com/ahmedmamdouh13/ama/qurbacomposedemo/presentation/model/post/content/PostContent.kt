package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.content

import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.promo.PromoModel

data class PostContent(
    val type: ContentType,
    var text: String = "",
    var images: List<String> = listOf(),
    var sharedPost: PostModel? = null,
    var promo: PromoModel? = null,
    var actionButtonText: String = ""
)
