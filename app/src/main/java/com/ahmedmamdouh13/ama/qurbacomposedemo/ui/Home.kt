package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.data.DataSource
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ContentType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostContent
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.comment.CommentModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.PostProfileModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.ProfileType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo.PromoModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostItem
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.sample

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
    val sharedPost = PostModel(
        profileModel = PostProfileModel(
            0,
            0,
            "Ahmed Mamdouh",
            R.drawable.pp,
            1645730335701L,
            ProfileType.VENDOR,
            isVerified = false
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
                promo = PromoModel(
                    0,
                    1,
                    R.drawable.pp,
                    "Chicken MACDO, Carmel Sandae, Friday and all what you need now!!",
                    "MacDonald's",
                    actionButtonText = "View Menu",
                    isActionNeeded = true
                )
            ),

            ),
        topComment = CommentModel(
            0,
            0,
            "Mohamed Mady",
            R.drawable.pp,
            timestamp = 1645730335001L,
            commentText = "Nice food really!",
            likesCount = remember{ mutableStateOf(999L) }
        ),
        listOf(
            ReactionModel(1, remember { mutableStateOf(30) }, type),
            ReactionModel(1, remember { mutableStateOf(999) }, ReactionType.LIKE),
            ReactionModel(1, remember { mutableStateOf(0L) }, ReactionType.SHARE)
        )
    )
    val model = PostModel(
        profileModel = PostProfileModel(
            0,
            0,
            "Ahmed Mamdouh",
            R.drawable.pp,
            1645730335701L,
            ProfileType.VENDOR,
            isVerified = false
        ),
        content = listOf(
            PostContent(
                ContentType.TEXT,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eros est, blandit eu nunc sit amet"
            ),

            PostContent(
                ContentType.SHARED_POST,
                sharedPost = sharedPost
            ),


            ),
        topComment = CommentModel(
            0,
            0,
            "Mohamed Mady",
            R.drawable.pp,
            timestamp = 1645730335001L,
            commentText = "Nice food really!"
        ),
        listOf(
            ReactionModel(1, remember { mutableStateOf(13L) }, type),
            ReactionModel(1, remember { mutableStateOf(50) }, ReactionType.LIKE),
            ReactionModel(1, remember { mutableStateOf(0L) }, ReactionType.SHARE)
        )
    )
    LazyColumn(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {


        itemsIndexed(DataSource.getAllPosts()) { index, item ->

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            PostItem(
                model = item,
                onReactionClicked = {

                    if (it.type == ReactionType.LIKE) {

                        if (!it.isLiked.value)
                            it.count.value = it.count.value + 1
                        else  it.count.value = it.count.value - 1

                        it.isLiked.value = !it.isLiked.value
                    }

                },
                onLikeComment = {
                    if (!it.isLiked.value) {
                        it.likesCount.value = it.likesCount.value + 1
                    } else it.likesCount.value = it.likesCount.value - 1
                    it.isLiked.value = !it.isLiked.value
                }
            )
            Divider(color = PostDividerColorOffWhite50, thickness = 3.dp)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
    Home()
}