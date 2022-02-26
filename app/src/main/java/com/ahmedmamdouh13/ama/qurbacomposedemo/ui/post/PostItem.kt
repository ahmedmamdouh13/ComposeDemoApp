package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import android.content.res.Resources
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.BorderColorBlack
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.BorderColorOffWhite


@Composable
fun PostItem(
    model: PostModel,
    onReactionClicked: (ReactionModel) -> Unit = {},
    onMenuButtonClicked: () -> Unit = {},
    onLikeComment: (CommentModel) -> Unit = {},
) {
    Column {
        Box(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_16),
                    end = dimensionResource(id = R.dimen.padding_16)
                )
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



        PostContent(model, startEndPadding = dimensionResource(id = R.dimen.padding_16))
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
        Box(
            Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_16),
                end = dimensionResource(id = R.dimen.padding_16)
            )
        ) {
            PostDivider()
        }

        Box(
            Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_16),
                    end = dimensionResource(id = R.dimen.padding_16),
                    top = dimensionResource(id = R.dimen.padding_8)
                )
        ) {
            ReactionsBar(model.reactions) {
                when (it.type) {
                    ReactionType.LIKE -> onReactionClicked(it)
                    ReactionType.SHARE -> onReactionClicked(it)
                    ReactionType.COMMENT -> model.topComment.isVisible.value =
                        !model.topComment.isVisible.value
                }

            }
        }

        AnimatedVisibility(visible = model.topComment.isVisible.value,) {

            Column(
                Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_16),
                    end = dimensionResource(id = R.dimen.padding_16)
                )
            ) {
                PostDivider()
                Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))
                Comment(model = model.topComment){
                    onLikeComment(it)
                }
                Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))
            }
        }

    }

}

@Composable
fun Menu(onMenuButtonClicked: () -> Unit) {
    Image(
        painterResource(id = menu),
        contentDescription = "menu",
        modifier = Modifier.size(20.dp).clickable {
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
                    Text(
                        text = content.text, modifier = Modifier.padding(
                            start = startEndPadding,
                            end = startEndPadding
                        )
                    )
                }
                ContentType.IMAGE -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    ContentImages(content.images)
                }
                ContentType.SHARED_POST -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    Box(
                        modifier = Modifier.padding(
                            start = startEndPadding,
                            end = startEndPadding
                        )
                    ) {

                        SharedPost(content.sharedPost)
                    }
                }
                ContentType.PROMO -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    Box(
                        modifier = Modifier.padding(
                            start = startEndPadding,
                            end = startEndPadding
                        )
                    ) {
                        Promo(content.promo!!, onClickActionButton = onPromoActionClick)

                    }

                }
            }
        }
    }
}

@Composable
fun PostDivider() {
    Divider(
        thickness = 0.5.dp,
        color = BorderColorBlack
    )
}

@Composable
fun SharedPost(model: PostModel?) {
    Column(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.padding_16),
                end = dimensionResource(id = R.dimen.padding_16)
            )
            .clip(shape = RoundedCornerShape(7.dp))
            .border(1.dp, color = BorderColorOffWhite, RoundedCornerShape(7.dp))
    ) {

        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
        Box(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_8),
                    end = dimensionResource(id = R.dimen.padding_8)
                )
        ) {
            PostProfile(model = model!!.profileModel)
        }
        PostContent(
            model = model!!,
            startEndPadding = dimensionResource(id = R.dimen.padding_8)
        )
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))
    }

}

const val defaultImageContentHeight = 192
const val paddingSize = 4

@Composable
fun ContentImages(images: List<Int>) { // TODO fix naming and organize code
    val displayMetrics = Resources.getSystem().displayMetrics
    var minImageWidthSize = (displayMetrics.widthPixels / displayMetrics.density) / 2
    var height = defaultImageContentHeight

    if (images.size > 1) height = calculateGridItemsHeight(images.size, paddingSize)
    else minImageWidthSize = (displayMetrics.widthPixels / displayMetrics.density)


    Row {
        Image(
            modifier = Modifier
                .width(minImageWidthSize.dp)
                .height(defaultImageContentHeight.dp),
            painter = painterResource(id = images[0]),
            contentDescription = "",
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.padding(start = paddingSize.dp))
        Column {
            for (i in 1 until images.size) {
                if (i != 1)
                    Spacer(modifier = Modifier.padding(top = paddingSize.dp))
                Image(
                    modifier = Modifier
                        .height(height.dp)
                        .width(minImageWidthSize.dp),
                    painter = painterResource(id = images[i]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

    }


}

fun calculateGridItemsHeight(itemCount: Int, paddingSize: Int): Int {
    return ((defaultImageContentHeight - ((itemCount - 2) * paddingSize)) / (itemCount - 1))
}
