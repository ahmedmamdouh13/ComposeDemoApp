package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.menu
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ContentType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.comment.CommentModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo.PromoModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content.ContentText
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content.GridContentImages
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content.Promo
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content.SharedPost
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.BorderColorBlack


@Composable
fun PostItem(
    model: PostModel,
    onReactionClicked: (ReactionModel) -> Unit = {},
    onMenuButtonClicked: () -> Unit = {},
    onLikeComment: (CommentModel) -> Unit = {},
    onPromoActionClick: (PromoModel) -> Unit = {},
) {
    val startEndPadding = dimensionResource(id = R.dimen.padding_16)
    val topPadding = dimensionResource(id = R.dimen.padding_8)

    Column {

        PostPadding(startEndPadding = startEndPadding) {
            PostHeader(model, onMenuButtonClicked) // Profile and menu
        }

        PostContent(model, onPromoActionClick, startEndPadding) // Post Content



        if (isDividerNeeded(model)) {
            Spacer(modifier = Modifier.padding(top = topPadding))
            PostPadding(startEndPadding = startEndPadding) {
                PostDivider()
            }
        }

        Spacer(modifier = Modifier.padding(top = topPadding))

        PostPadding(startEndPadding = startEndPadding) {
            PostReactions(model, onReactionClicked)  // Likes, Comments and Shares count.
        }

        PostPadding(startEndPadding = startEndPadding) {
            PostTopComment(model, onLikeComment) // Top/Apparent comment.
        }

    }

}

private fun isDividerNeeded(model: PostModel): Boolean {
    return model.content.find { it.promo != null } != null
}

@Composable
fun PostHeader(model: PostModel, onMenuButtonClicked: () -> Unit) {

    Box(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()

    ) {
        Box(
            Modifier
                .wrapContentSize()
                .align(Alignment.TopStart)

        ) {
            PostProfile(model = model.profileModel)
        }

        Box(
            Modifier
                .wrapContentSize()
                .align(Alignment.TopEnd)

        ) {
            Menu(onMenuButtonClicked)
        }


    }
}

@Composable
fun PostReactions(model: PostModel, onReactionClicked: (ReactionModel) -> Unit) {
    Box(Modifier.wrapContentSize()) {
        ReactionsBar(model.reactions) {
            when (it.type) {
                ReactionType.LIKE -> onReactionClicked(it)
                ReactionType.SHARE -> onReactionClicked(it)
                ReactionType.COMMENT -> model.topComment.isVisible.value =
                    !model.topComment.isVisible.value
            }

        }
    }
}

@Composable
fun PostTopComment(model: PostModel, onLikeComment: (CommentModel) -> Unit) {
    AnimatedVisibility(visible = model.topComment.isVisible.value) {
        Column(

        ) {
            PostDivider()

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            Comment(model = model.topComment, onLikeComment::invoke)

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))
        }
    }
}

@Composable
fun Menu(onMenuButtonClicked: () -> Unit) {
    Image(
        painterResource(id = menu),
        contentDescription = "menu",
        modifier = Modifier
            .size(20.dp)
            .clickable {
                onMenuButtonClicked()
            }
    )
}

@Composable
fun PostContent(
    model: PostModel,
    onPromoActionClick: (PromoModel) -> Unit = {},
    startEndPadding: Dp,

    ) {
    Column {
        model.content.forEach { content ->
            when (content.type) {
                ContentType.TEXT -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    PostPadding(startEndPadding) { ContentText(content.text) }
                }
                ContentType.IMAGE -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    GridContentImages(content.images)
                }
                ContentType.SHARED_POST -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    PostPadding(startEndPadding) { SharedPost(content.sharedPost) }
                }
                ContentType.PROMO -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    PostPadding(startEndPadding) { Promo(content.promo!!, onPromoActionClick) }
                }
            }
        }
    }
}

@Composable
fun PostPadding(startEndPadding: Dp, item: @Composable () -> Unit) {
    Box(
        modifier = Modifier.padding(
            start = startEndPadding,
            end = startEndPadding
        )
    ) {
        item()
    }
}


@Composable
fun PostDivider() {
    Divider(
        thickness = 0.5.dp,
        color = BorderColorBlack
    )
}


