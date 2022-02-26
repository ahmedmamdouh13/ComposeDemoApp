package com.ahmedmamdouh13.ama.qurbacomposedemo.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.PostViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home.PostList

@Composable
fun Home(postViewModel: PostViewModel = viewModel(),
         context: Context = LocalContext.current) {

    PostList(postViewModel)

    postViewModel.getAllPosts(context)

}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
//    Home()
}