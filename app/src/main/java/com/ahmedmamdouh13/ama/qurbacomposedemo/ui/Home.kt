package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.home.HomeViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.BottomNavigationBar
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.CreatePost
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.PostList
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.TopBar
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50

@Composable
fun Home(
    postViewModel: PostViewModel = viewModel(),
    homeViewModel: HomeViewModel = viewModel(),
    context: Context = LocalContext.current
) {

    Box(Modifier.fillMaxSize()) {

        PostList(postViewModel, homeViewModel)

        Column {
            TopBar()
        }

        Box(
            Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar(homeViewModel.bottomNavigationState)
        }
    }

    postViewModel.getAllPosts(context)

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
//    Home()
}