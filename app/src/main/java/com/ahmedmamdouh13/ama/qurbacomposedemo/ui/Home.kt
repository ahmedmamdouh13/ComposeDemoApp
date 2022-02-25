package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import androidx.compose.runtime.Composable
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ContentType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostContent
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.PostProfileModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.ProfileType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.SharedWith
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo.PromoModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostItem
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount

@Composable
fun Home() {
    val displayableCount = (65465411321L).toDisplayableCount()
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

//    PostProfile(
//        model = PostProfileModel(
//            0,
//            0,
//            "Ahmed Mamdouh",
//            R.drawable.pp,
//            1645730335701L,
//            ProfileType.BUYER,
//            SharedWith(0, 0, "Mohamed Mady", ProfileType.BUYER, false),
//            true
//        )
//    )

    PostItem(
        model = PostModel(
            profileModel = PostProfileModel(
                0,
                0,
                "Ahmed Mamdouh",
                R.drawable.pp,
                1645730335701L,
                ProfileType.BUYER,
                SharedWith(0, 0, "Mohamed Mady", ProfileType.BUYER, false),
                true
            ),
            content = listOf(
                PostContent(
                    ContentType.TEXT,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eros est, blandit eu nunc sit amet"
                ),
                PostContent(
                    ContentType.IMAGE, "It tastes Great!",
                    listOf(R.drawable.pp, R.drawable.pp, R.drawable.pp, R.drawable.pp, R.drawable.pp)
                ),

                PostContent(
                    ContentType.PROMO,
                    promo = PromoModel(0,1, R.drawable.pp, "Chicken MACDO, Carmel Sandae, Friday and all what you need now!!",
                        "MacDonald's", isActionNeeded = true, actionButtonText = "View Menu"
                        )
                ),

                ),
            listOf(
                ReactionModel(1, displayableCount, type),
                ReactionModel(1, displayableCount, ReactionType.LIKE),
                ReactionModel(1, displayableCount, ReactionType.SHARE)
            )
        )
    )

}