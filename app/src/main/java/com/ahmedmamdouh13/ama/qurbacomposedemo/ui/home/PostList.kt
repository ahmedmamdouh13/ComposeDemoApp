package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.home.HomeViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostDivider
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostItem
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostPadding
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50

@Composable
fun PostList(viewModel: PostViewModel, homeViewModel: HomeViewModel) {

    val model by viewModel.postsLiveData.observeAsState(listOf())


    AnimatedVisibility(visible = model.isEmpty()) {
        ShimmerList()
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

            item {

                    CreatePost(
                        userProfilePic = homeViewModel.userProfilePicture,
                        textState = homeViewModel.createPostState
                    )

                Divider(color = PostDividerColorOffWhite50, thickness = 3.dp)

            }

            itemsIndexed(model) { _, item ->
                    Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

                    PostItem(
                        model = item,
                        onReactionClicked = { viewModel.onClickReaction(it) },
                        onLikeComment = { viewModel.onLikeComment(it) },
                        onMenuButtonClicked = { viewModel.onMenuButtonClick() },
                        onPromoActionClick = { viewModel.onPromoActionClick(it) }
                    )

                    Divider(color = PostDividerColorOffWhite50, thickness = 3.dp)
            }

            item {
                Box(modifier = Modifier.height(barHeight)) // to slide content under the top bar
            }
        }


}
