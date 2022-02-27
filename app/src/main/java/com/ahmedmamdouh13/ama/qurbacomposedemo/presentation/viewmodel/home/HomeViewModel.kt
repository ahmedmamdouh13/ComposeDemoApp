package com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.viewmodel.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.home.BottomNavigationStateType

class HomeViewModel: ViewModel() {

    val bottomNavigationState = mutableStateOf(BottomNavigationStateType.HOME)
    val createPostState: MutableState<String> = mutableStateOf("")
    val userProfilePicture: String = "android.resource://com.ahmedmamdouh13.ama.qurbacomposedemo/drawable/profile_2"


}