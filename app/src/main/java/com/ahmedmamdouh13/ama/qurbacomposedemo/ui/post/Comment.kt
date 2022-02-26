package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.commentLike
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.comment.CommentModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.CommentBackgroundColorWhitish
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.Typography
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.Timestamp
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableDateTime

@Composable
fun Comment(model: CommentModel, onLikeClicked: (CommentModel) -> Unit) {

    Row(modifier = Modifier.wrapContentSize()) {
        Box() {
            ProfilePicture(profilePicRes = model.profilePicUrl)
        }

        Spacer(
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_4),
                end = dimensionResource(id = R.dimen.padding_4)
            )
        )

        Column {
            CommentBubble(model.userName, model.commentText)



            Row {
                Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_8)))
                TimePassed(model.timestamp)
                Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_16)))
                LikeButton(model.isLiked) {
                    onLikeClicked(model)
                }
                Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_16)))
                ReplyButton()
                Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_16)))

                LikeCount(model.likesCount.value.toDisplayableCount())

            }
        }


    }
}

@Composable
fun LikeCount(displayableLikesCount: String) {
    AnimatedVisibility(displayableLikesCount.isNotEmpty(), enter = fadeIn(), exit = fadeOut()) {
        Row {
            Text(text = displayableLikesCount, style = Typography.body2)
            Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_4)))
            Image(painter = painterResource(id = commentLike), contentDescription = "comment like")
        }
    }
}

@Composable
fun ReplyButton() {

    Text(
        modifier = Modifier.clickable { },
        text = stringResource(id = R.string.reply),
        style = Typography.body2
    )
}


@Composable
fun LikeButton(liked: MutableState<Boolean>, onLikeClicked: (Boolean) -> Unit) {
    val text = if (!liked.value) stringResource(id = R.string.like)
    else stringResource(id = R.string.unlike)
    Text(modifier = Modifier.toggleable(value = liked.value, onValueChange = {
        onLikeClicked(it)
    }), text = text, style = Typography.body2)
}

@Composable
fun TimePassed(timestamp: Timestamp) {
    Text(text = timestamp.toDisplayableDateTime(), style = Typography.body2)
}

@Composable
fun CommentBubble(userName: String, commentText: String) {

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(
                color = CommentBackgroundColorWhitish,
                shape = RoundedCornerShape(13.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(
                top = dimensionResource(id = R.dimen.padding_8),
                bottom = dimensionResource(id = R.dimen.padding_8),
                start = dimensionResource(id = R.dimen.padding_12),
                end = dimensionResource(id = R.dimen.padding_18)
            )
        ) {
            ProfileHeader(userName = userName, titleTextStyle = Typography.h2)
            Text(text = commentText, style = Typography.body1, fontSize = 12.sp)
        }

    }

}
//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun PreviewComment() {
//    val mutableStateOf = remember { mutableStateOf(120L) }
//
//    Comment(
//        model = CommentModel(
//            0,
//            0,
//            "Ahmed Mamoduh",
//            R.drawable.pp,
//            mutableStateOf,
//            1645730335701L,
//            "Very good quality! alksm laksd lajsld ;laksd l;asd;lasdf ;asdk ujfkf"
//        )
//    ) {
//        if (it.isLiked.value) {
//            mutableStateOf.value = 119L
//        } else mutableStateOf.value = 121L
//
//        it.isLiked.value = !it.isLiked.value
//    }
//
//}
