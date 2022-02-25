package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.ContentType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo.PromoModel


@Composable
fun PostItem(model: PostModel) {
    Column {

        Box(
            Modifier
                .wrapContentSize()
                .align(Alignment.Start)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_16),
                    end = dimensionResource(id = R.dimen.padding_16)
                )
        ) {
            PostProfile(model = model.profileModel)
        }


        PostContent(model,)


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

            }
        }


    }

}

@Composable
fun PostContent(model: PostModel, onPromoActionClick: (PromoModel) -> Unit = {}) {

    Column {
        model.content.forEach { content ->
            when (content.type) {
                ContentType.TEXT -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    Text(
                        text = content.text, modifier = Modifier.padding(
                            start = dimensionResource(id = R.dimen.padding_16),
                            end = dimensionResource(id = R.dimen.padding_16)
                        )
                    )
                }
                ContentType.IMAGE -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    Box(modifier = Modifier.height(300.dp)) { ContentImages(content.images) }
                }
                ContentType.SHARED_POST -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    SharedPost(content.sharedPost)
                }
                ContentType.PROMO -> {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))
                    Promo(content.promo!!,onClickActionButton = onPromoActionClick)
                }
            }
        }
    }
}

@Composable
fun SharedPost(sharedPost: PostModel?) {


}

@Composable
fun ContentImages(images: List<Int>) { // TODO fix naming and organize code
    val displayMetrics = Resources.getSystem().displayMetrics
    var minImageWidthSize = (displayMetrics.widthPixels / displayMetrics.density) / 2
    val height = if (images.size > 1) (300 / (images.size - 1)) else {

        minImageWidthSize = (displayMetrics.widthPixels / displayMetrics.density)
        300
    }

    Row {
        Image(
            modifier = Modifier
                .width(minImageWidthSize.dp)
                .fillMaxHeight(),
            painter = painterResource(id = images[0]),
            contentDescription = "",
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_4)))
        Column {
            for (i in 1 until images.size) {
                if (i != 1)
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_4)))
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
