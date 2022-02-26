package com.ahmedmamdouh13.ama.qurbacomposedemo.data.local

import android.content.Context
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.model.Posts
import com.google.gson.Gson

object LocalDataSource {
    suspend fun getAllPosts(context: Context): Posts {
        val json = context.resources.openRawResource(R.raw.api).bufferedReader().use { it.readText() }
        return Gson().fromJson(json, Posts::class.java)
    }
    }
//
//    private fun getPost1(): PostModel {
//        return PostModel(
//            PostProfileModel(
//                id1,
//                id1,
//                userName1,
//                profile1,
//                timestamp,
//                ProfileType.BUYER,
//                null,
//                true
//            ),
//            listOf(
//                PostContent(ContentType.TEXT, text = contentText1),
//                PostContent(ContentType.IMAGE, images = listOf(dish1, dish2, dish3)),
//                PostContent(
//                    ContentType.PROMO,
//                    promo = PromoModel(id1, id1, vendor1, promoTitle1, promoSubtitle1)
//                ),
//            ),
//            topComment = CommentModel(
//                id1,
//                id1,
//                userName2,
//                profile2,
//                mutableStateOf(5),
//                timestamp,
//                "Very good!"
//            ),
//            reactions = listOf(
//                ReactionModel(id1, type = ReactionType.LIKE, count = mutableStateOf(100)),
//                ReactionModel(id1, type = ReactionType.COMMENT, count = mutableStateOf(30)),
//                ReactionModel(id1, type = ReactionType.SHARE, count = mutableStateOf(10))
//            )
//        )
//    }
//
//    private fun getPost2(): PostModel {
//        return PostModel(
//            PostProfileModel(
//                id2,
//                id2,
//                userName2,
//                profile2,
//                timestamp,
//                ProfileType.BUYER,
//                null,
//                true
//            ),
//            listOf(
//                PostContent(ContentType.TEXT, text = contentText2),
//                PostContent(ContentType.IMAGE, images = listOf(dish3, dish4, dish7, dish5)),
//                PostContent(
//                    ContentType.PROMO,
//                    promo = PromoModel(
//                        id2,
//                        id2,
//                        vendor2,
//                        promoTitle2,
//                        promoSubtitle2,
//                        "View Menu",
//                        true
//                    )
//                ),
//            ),
//            topComment = CommentModel(
//                id2,
//                id2,
//                userName1,
//                profile1,
//                mutableStateOf(5),
//                timestamp,
//                "Very good!"
//            ),
//            reactions = listOf(
//                ReactionModel(id1, type = ReactionType.LIKE, count = mutableStateOf(999)),
//                ReactionModel(id1, type = ReactionType.COMMENT, count = mutableStateOf(30)),
//                ReactionModel(id1, type = ReactionType.SHARE, count = mutableStateOf(200))
//            )
//        )
//    }
//
//    private fun getPost3(): PostModel {
//        return PostModel(
//            PostProfileModel(
//                id3,
//                id3,
//                userName3,
//                profile3,
//                timestamp,
//                ProfileType.BUYER,
//                null,
//                true
//            ),
//            listOf(
//                PostContent(ContentType.TEXT, text = contentText3),
//                PostContent(ContentType.SHARED_POST, sharedPost = getPost1())
//            ),
//            topComment = CommentModel(
//                id3,
//                id3,
//                userName1,
//                profile1,
//                mutableStateOf(5),
//                timestamp,
//                "Very good!"
//            ),
//            reactions = listOf(
//                ReactionModel(id1, type = ReactionType.LIKE, count = mutableStateOf(999)),
//                ReactionModel(id1, type = ReactionType.COMMENT, count = mutableStateOf(30)),
//                ReactionModel(id1, type = ReactionType.SHARE, count = mutableStateOf(200))
//            )
//        )
//    }
//
//    private fun getPost4(): PostModel {
//        return PostModel(
//            PostProfileModel(
//                id4,
//                id4,
//                promoSubtitle3,
//                vendor3,
//                timestamp,
//                ProfileType.VENDOR,
//                null,
//                true
//            ),
//            listOf(
//                PostContent(ContentType.TEXT, text = promoTitle5),
//                PostContent(ContentType.IMAGE, images = listOf(dish7)),
//                PostContent(
//                    ContentType.PROMO, promo = PromoModel(
//                        id3,
//                        id3,
//                        vendor3,
//                        promoTitle3,
//                        promoSubtitle3,
//                        "View Menu",
//                        true
//                    )
//                )
//            ),
//            topComment = CommentModel(
//                id3,
//                id3,
//                userName1,
//                profile1,
//                mutableStateOf(5),
//                timestamp,
//                "Very good!"
//            ),
//            reactions = listOf(
//                ReactionModel(id1, type = ReactionType.LIKE, count = mutableStateOf(999)),
//                ReactionModel(id1, type = ReactionType.COMMENT, count = mutableStateOf(30)),
//                ReactionModel(id1, type = ReactionType.SHARE, count = mutableStateOf(200))
//            )
//        )
//    }