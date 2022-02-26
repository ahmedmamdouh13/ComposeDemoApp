package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50

@Composable
fun PostList(viewModel: PostViewModel = viewModel()) {

    val model by viewModel.postsLiveData.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {

        itemsIndexed(model) { index, item ->

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            PostItem(
                model = item,
                onReactionClicked = { viewModel.onClickReaction(it) },
                onLikeComment = { viewModel.onLikeComment(it) },
                onMenuButtonClicked = { viewModel.onMenuButtonClick() },
                onPromoActionClick = {viewModel.onPromoActionClick(it)}
            )

            Divider(color = PostDividerColorOffWhite50, thickness = 3.dp)
        }


    }


}