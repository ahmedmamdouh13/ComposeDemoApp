package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.comment
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.like
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.share
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PromoActionButtonTextColor
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount

@Composable
private fun Reaction(model: ReactionModel, onClick: (ReactionModel) -> Unit) {
    val icon = getIcon(model.type)

    Row(modifier = Modifier
        .wrapContentSize()
        .padding(2.dp)
        .clip(RoundedCornerShape(4.dp))
        .clickable(role = Role.Button) { onClick(model) }
    ) {

        Text(
            text = model.count.value.toDisplayableCount(), textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.size(4.dp))

        Image(
            painter = painterResource(id = icon),
            contentDescription = model.type.name, alignment = Alignment.Center, modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically),
            colorFilter = getLikeState(model)
        )
    }

}

fun getLikeState(model: ReactionModel): ColorFilter {
   return if (model.isLiked.value && model.type == ReactionType.LIKE) ColorFilter.lighting(
        PromoActionButtonTextColor,
        PromoActionButtonTextColor
    )
    else ColorFilter.colorMatrix(ColorMatrix())
}


private fun getIcon(type: ReactionType): Int = when (type) {
    ReactionType.LIKE -> like
    ReactionType.SHARE -> share
    ReactionType.COMMENT -> comment
}


@Composable
fun ReactionsBar(reactions: List<ReactionModel>, onReactionClicked: (ReactionModel) -> Unit) {
    val like = reactions.find { it.type == ReactionType.LIKE }!!
    val comment = reactions.find { it.type == ReactionType.COMMENT }!!
    val share = reactions.find { it.type == ReactionType.SHARE }!!

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {

        Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.fillMaxWidth()) {
            Reaction(model = like, onReactionClicked::invoke)
        }

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Reaction(model = comment, onReactionClicked::invoke)
        }

        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth()) {
            Reaction(model = share, onReactionClicked::invoke)
        }

    }

}

//preview......
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewReaction() {
    val displayableCount = (800L).toDisplayableCount()
    val type = ReactionType.COMMENT
    Reaction(ReactionModel(0, remember { mutableStateOf(800L) }, type)) {
        println(it.type.name + " here!!!")
    }

}