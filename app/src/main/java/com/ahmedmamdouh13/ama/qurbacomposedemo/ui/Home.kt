package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import androidx.compose.runtime.Composable
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.PostProfileModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.ProfileType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.SharedWith
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.SharedWithType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostProfile
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.ReactionsBar
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableDateTime

@Composable
fun Home() {
    val displayableCount = (0L).toDisplayableCount()
    val type = ReactionType.COMMENT
//
//    ReactionsBar(
//        reactions = listOf(
//            ReactionModel(1, "13", type),
//            ReactionModel(1, displayableCount, ReactionType.LIKE),
//            ReactionModel(1, displayableCount, ReactionType.SHARE)
//        )
//    ) {
//        println(it.type.name + " Wussaaaap")
//        println(0L.toDisplayableDateTime() + " Homie ")
//    }

    PostProfile(
        model = PostProfileModel(
            0,
            0,
            "Ahmed Mamdouh",
            R.drawable.pp,
            1645730335701L,
            ProfileType.BUYER,
            SharedWith(0, 0, "Mohamed Mady", ProfileType.BUYER, false),
            true
        )
    )

}