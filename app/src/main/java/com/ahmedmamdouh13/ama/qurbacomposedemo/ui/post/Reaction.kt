package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ReactionModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ReactionsBarModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableCount

@Composable
fun Reaction(model: ReactionModel, onClick: (ReactionType) -> Unit) {
    val icon = getIcon(model.type)

    Row(modifier = Modifier
        .wrapContentSize()
        .padding(2.dp)
        .clip(RoundedCornerShape(4.dp))
        .clickable(role = Role.Button) { onClick(model.type) }
    ) {

        Text(
            text = model.displayableCount, textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.size(4.dp))

        Image(
            painter = painterResource(id = icon),
            contentDescription = model.type.name, alignment = Alignment.Center, modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
        )
    }

}

@Composable
fun ReactionsBar(model: ReactionsBarModel) {

    Reaction(model = model.likes, onClick = {
        println(it.name)
    })

}

private fun getIcon(type: ReactionType): Int = when (type) {
    ReactionType.LIKE -> R.drawable.ic_like
    ReactionType.SHARE -> R.drawable.ic_share
    ReactionType.COMMENT -> R.drawable.ic_comment
}


//preview......
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewReaction() {
    val displayableCount = (80000L).toDisplayableCount()
    val type = ReactionType.COMMENT
    Reaction(ReactionModel(displayableCount, type)){
        println(it.name + " here!!!")
    }

}