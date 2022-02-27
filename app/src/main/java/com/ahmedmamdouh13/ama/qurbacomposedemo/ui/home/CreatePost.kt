package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.ProfilePicture
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.CreatePostBlackishColor
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.Typography

@Composable
fun CreatePost(userProfilePic: String, textState: MutableState<String>) {
    Box(
        Modifier
            .height(dimensionResource(id = R.dimen.createPostHeight))
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Row(
            Modifier
                .wrapContentSize()
                .align(Alignment.Center)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_16),
                    end = dimensionResource(id = R.dimen.padding_16)
                )
        ) {

            ProfilePicture(profilePicRes = userProfilePic)

            Spacer(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_12)))

            CreatePostTextField(textState)

        }
    }


}

@Composable
fun CreatePostTextField(textState: MutableState<String>) {

    Box(
        modifier = Modifier
            .height(38.dp)
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .offset((-2).dp, (-2).dp)
            .shadow(1.dp, RoundedCornerShape(bottomEnd = 20.dp, topEnd = 20.dp))

    ) {

        BasicTextField(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.CenterStart)
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            textStyle = Typography.body2,

            )

        if (textState.value.isEmpty()) // hint
            HintPlaceHolder()
    }
}

@Composable
fun HintPlaceHolder() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .alpha(0.5f)
                .align(Alignment.CenterStart)
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
            text = "Share your food experiences",
            style = Typography.body2,
            color = CreatePostBlackishColor

        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreatePost() {
    CreatePost(userProfilePic = "", textState = remember {
        mutableStateOf("Something")
    })
}