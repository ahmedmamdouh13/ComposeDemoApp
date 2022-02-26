package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import android.app.Activity
import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.HomeViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostItem
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50

@Composable
fun Home(homeViewModel: HomeViewModel = viewModel(), context: Context = LocalContext.current) {

    val model by homeViewModel.postsLiveData.observeAsState(listOf())
    LazyColumn(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {


        itemsIndexed(model) { index, item ->

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            PostItem(
                model = item,
                onReactionClicked = {

                    if (it.type == ReactionType.LIKE) {

                        if (!it.isLiked.value)
                            it.count.value = it.count.value + 1
                        else  it.count.value = it.count.value - 1

                        it.isLiked.value = !it.isLiked.value
                    }

                },
                onLikeComment = {
                    if (!it.isLiked.value) {
                        it.likesCount.value = it.likesCount.value + 1
                    } else it.likesCount.value = it.likesCount.value - 1
                    it.isLiked.value = !it.isLiked.value
                }
            )
            Divider(color = PostDividerColorOffWhite50, thickness = 3.dp)
        }


    }

    homeViewModel.getAllPosts(context)

//    LazyColumn(
//        modifier = Modifier
//            .wrapContentHeight()
//            .fillMaxWidth()
//    ) {
//
//
//        itemsIndexed(DataSource.getAllPosts(context)) { index, item ->
//
//            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))
//
//            PostItem(
//                model = item,
//                onReactionClicked = {
//
//                    if (it.type == ReactionType.LIKE) {
//
//                        if (!it.isLiked.value)
//                            it.count.value = it.count.value + 1
//                        else  it.count.value = it.count.value - 1
//
//                        it.isLiked.value = !it.isLiked.value
//                    }
//
//                },
//                onLikeComment = {
//                    if (!it.isLiked.value) {
//                        it.likesCount.value = it.likesCount.value + 1
//                    } else it.likesCount.value = it.likesCount.value - 1
//                    it.isLiked.value = !it.isLiked.value
//                }
//            )
//            Divider(color = PostDividerColorOffWhite50, thickness = 3.dp)
//        }
//    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
//    Home()
}