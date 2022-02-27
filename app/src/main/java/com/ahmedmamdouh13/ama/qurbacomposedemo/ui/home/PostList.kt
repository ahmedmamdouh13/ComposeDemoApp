package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.home.HomeViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostItem
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50

@Composable
fun PostList(viewModel: PostViewModel, homeViewModel: HomeViewModel) {

    val model by viewModel.postsLiveData.observeAsState(listOf())


    AnimatedVisibility(visible = model.isEmpty()) {
        Placeholder() // posts placeholder
    }

    val barHeight = dimensionResource(id = R.dimen.barHeight)


    LazyColumn(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {

        item {
            Box(modifier = Modifier.height(barHeight)) // to slide content under the top bar
        }

        item { // Share your thoughts on food part.
            CreatePost(
                userProfilePic = homeViewModel.userProfilePicture,
                textState = homeViewModel.createPostState
            )
        }

        itemsIndexed(model) { _, item ->

            Divider( // divider between posts
                color = PostDividerColorOffWhite50,
                thickness = dimensionResource(id = R.dimen.dividerThickness)
            )

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            PostItem(
                model = item,
                onReactionClicked = { viewModel.onClickReaction(it) },
                onLikeComment = { viewModel.onLikeComment(it) },
                onMenuButtonClicked = { viewModel.onMenuButtonClick() },
                onPromoActionClick = { viewModel.onPromoActionClick(it) }
            )

        }

        item {
            Box(modifier = Modifier.height(barHeight)) // to slide content under the navigation bar
        }
    }


}
