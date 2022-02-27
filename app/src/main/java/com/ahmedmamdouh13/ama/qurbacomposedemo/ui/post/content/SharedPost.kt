package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.PostModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.base.StartEndPadding
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostContent
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostProfile
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.BorderColorOffWhite

@Composable
fun SharedPost(model: PostModel) {
    Column(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.padding_16),
                end = dimensionResource(id = R.dimen.padding_16)
            )
            .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.sharedPostBorderCorner)))
            .border(1.dp, color = BorderColorOffWhite, RoundedCornerShape(dimensionResource(id = R.dimen.sharedPostBorderCorner)))
    ) {

        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))

        StartEndPadding(startEndPadding = dimensionResource(id = R.dimen.padding_8)) {
            PostProfile(model = model.profileModel)
        }

        PostContent(model = model, startEndPadding = dimensionResource(id = R.dimen.padding_8))

        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))
    }

}