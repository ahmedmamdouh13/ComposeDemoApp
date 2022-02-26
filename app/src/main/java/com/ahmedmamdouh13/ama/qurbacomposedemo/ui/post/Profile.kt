package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.arrow
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.blueTick
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.PostProfileModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.ProfileType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.profile.SharedWith
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.restaurant
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.Typography
import com.ahmedmamdouh13.ama.qurbacomposedemo.util.toDisplayableDateTime

@Composable
fun PostProfile(model: PostProfileModel) {
    val isSharing = model.sharedWith != null
    Row(
        modifier = Modifier.wrapContentSize()
    ) {


        ProfilePicture(model.profilePicRes)

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {

            ProfileHeader(
                isVerified = model.isVerified,
                model.userName,
                isSharing,
                model.profileType == ProfileType.VENDOR
            )

            Spacer(modifier = Modifier.padding(top = 1.dp))

            if (isSharing)
                ProfileHeader(
                    isVerified = model.sharedWith!!.isVerified,
                    userName = model.sharedWith!!.sharedWithName,
                )

            Spacer(modifier = Modifier.padding(top = 1.dp))

            Text(
                text = model.timestamp.toDisplayableDateTime(),
                style = Typography.subtitle1
            )
        }

    }
}

@Composable
fun ProfileHeader(
    isVerified: Boolean = false,
    userName: String,
    isSharing: Boolean = false,
    isVendor: Boolean = false,
    titleTextStyle: TextStyle = Typography.h1,
) {
    Row {
        Text(
            text = userName,
            style = titleTextStyle,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis
        )

        if (isVerified && !isVendor)
            Image(
                modifier = Modifier
                    .size(15.dp)
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = blueTick),
                contentDescription = "Verified",
                alignment = Alignment.Center,
            )

        if (isVendor && isVerified)
            Image(
                modifier = Modifier
                    .size(18.dp)
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = restaurant),
                contentDescription = "Vendor",
                alignment = Alignment.Center,
            )

        if (isSharing)
            Image(
                modifier = Modifier
                    .size(15.dp)
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = arrow),
                contentDescription = "Arrow",
                alignment = Alignment.Center,
            )

    }

}


@Composable
fun ProfilePicture(profilePicRes: Int) {
    Image(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(20.dp)),
        painter = painterResource(id = profilePicRes),
        contentDescription = ""
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPostProfile() {
    PostProfile(
        model = PostProfileModel(
            0,
            0,
            "Ahmed Mamdouh",
            R.drawable.pp,
            1645730335701L,
            ProfileType.BUYER,
            SharedWith(0, 0, "Mohamed Mady", ProfileType.BUYER, false),
            false
        )
    )
}