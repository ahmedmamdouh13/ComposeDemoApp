package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostPadding
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.BorderColorOffWhite


@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(1.dp,RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp))
            .offset(y = (-1).dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp)
            ).clip( RoundedCornerShape(bottomStart = 4.dp, bottomEnd = 4.dp))


    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.CenterStart)
        ) {
            PostPadding(startEndPadding = dimensionResource(id = R.dimen.padding_16)) {

                LogoIcon()
            }
        }


        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = dimensionResource(id = R.dimen.padding_16))
                .wrapContentSize()
        ) {
            SearchIcon()
            Spacer(modifier = Modifier.padding(start = 28.dp))
            NotificationIcon()
            Spacer(modifier = Modifier.padding(start = 28.dp))
            CartIcon()
        }

    }
}

@Composable
fun SearchIcon() {
    Image(
        modifier = Modifier
            .clickable { }, painter = painterResource(id = R.drawable.ic_search),
        contentDescription = "search", contentScale = ContentScale.Inside
    )
}

@Composable
fun NotificationIcon() {
    Image(
        modifier = Modifier
            .clickable { },
        painter = painterResource(id = R.drawable.ic_notification),
        contentDescription = "notification", contentScale = ContentScale.Inside
    )
}

@Composable
fun CartIcon() {
    Image(
        modifier = Modifier
            .clickable { }, painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "cart", contentScale = ContentScale.Fit
    )
}

@Composable
fun LogoIcon() {
    Image(
        modifier = Modifier.clickable { },
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = "logo"
    )
}


@Preview(showSystemUi = true)
@Composable
fun PreviewTopBar() {
    TopBar()
}