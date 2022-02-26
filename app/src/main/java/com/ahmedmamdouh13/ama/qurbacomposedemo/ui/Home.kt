package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.post.reaction.ReactionType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostItem
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostList
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50

@Composable
fun Home(postViewModel: PostViewModel = viewModel(), context: Context = LocalContext.current) {

    PostList(postViewModel)

    postViewModel.getAllPosts(context)

}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
//    Home()
}