package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.PostPadding
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.ShimmerColorGray
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.ShimmerColorWhitishGray

@Composable
fun Shimmer(){
    Column {

        PostPadding(startEndPadding = dimensionResource(id =R.dimen.padding_16)) {

            Row {
              ShimmerCircle()
                PostPadding(startEndPadding = dimensionResource(id = R.dimen.padding_8)) {

                    Column {
                        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_10)))

                        ShimmerTitle()
                        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_10)))

                        ShimmerSubtitle()
                    }
                }
            }

        }

        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_8)))

        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(192.dp)
            .background(color = ShimmerColorGray)
        )

        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_16)))

        PostPadding(startEndPadding = dimensionResource(id =R.dimen.padding_16)) {
            ShimmerReactions()
        }
    }

}

@Composable
fun ShimmerReactions() {
    Box {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart)
        {
            ShimmerReactionItem()
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center)
        {
            ShimmerReactionItem()
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd)
        {
            ShimmerReactionItem()
        }
    }
}

@Composable
fun ShimmerReactionItem() {
        Box(modifier = Modifier
            .width(50.dp)
            .height(10.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = ShimmerColorWhitishGray
            ))

}

@Composable
fun ShimmerSubtitle() {
    Box(modifier = Modifier
        .width(64.dp)
        .height(6.dp)
        .background(
            shape = RoundedCornerShape(4.dp),
            color = ShimmerColorWhitishGray
        )
    )
}

@Composable
fun ShimmerTitle() {
    Box(modifier = Modifier
        .width(120.dp)
        .height(10.dp)
        .background(
            shape = RoundedCornerShape(4.dp),
            color = ShimmerColorWhitishGray
        )
    )
}

@Composable
fun ShimmerCircle() {
    Box(modifier = Modifier
        .size(40.dp)
        .background(
            shape = RoundedCornerShape(20.dp),
            color = ShimmerColorWhitishGray
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewShimmer(){
    Shimmer()
}