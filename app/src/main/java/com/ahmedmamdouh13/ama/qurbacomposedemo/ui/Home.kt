package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.home.HomeViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.BottomNavigationBar
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.PostList
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.TopBar

@Composable
fun Home(
    postViewModel: PostViewModel = viewModel(),
    homeViewModel: HomeViewModel = viewModel(),
    context: Context = LocalContext.current
) {

    Box(Modifier.fillMaxSize()) { // Ordered by what's elevated on top last.

        PostList(postViewModel, homeViewModel) // List of posts

        TopBar() //  toolbar

        Box(
            Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar(homeViewModel.bottomNavigationState) // Bottom navigation
        }
    }

    // fetch all posts
    postViewModel.getAllPosts(context)

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
//    Home()
}