package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.base.StartEndPadding
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PostDividerColorOffWhite50
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.ShimmerColorGray
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.ShimmerColorWhitishGray


@Composable
fun Placeholder() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.barHeight))) // to slide content under the top bar
        Box(modifier = Modifier.height(dimensionResource(id = R.dimen.barHeight))) // to slide content under the top bar

        repeat(3) {
            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            Shimmer()

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_12)))

            Divider(color = PostDividerColorOffWhite50, thickness = dimensionResource(id = R.dimen.dividerThickness))
        }

    }
}


@Composable
fun Shimmer() {
    Column {

        StartEndPadding(startEndPadding = dimensionResource(id = R.dimen.padding_16)) {

            Row {
                ShimmerCircle()
                StartEndPadding(startEndPadding = dimensionResource(id = R.dimen.padding_8)) {

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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .height(192.dp)
                .background(color = ShimmerColorGray)
        )

        Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_16)))

        StartEndPadding(startEndPadding = dimensionResource(id = R.dimen.padding_16)) {
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
    Box(
        modifier = Modifier
            .width(50.dp)
            .height(10.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = ShimmerColorWhitishGray
            )
    )

}

@Composable
fun ShimmerSubtitle() {
    Box(
        modifier = Modifier
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
    Box(
        modifier = Modifier
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
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                shape = RoundedCornerShape(20.dp),
                color = ShimmerColorWhitishGray
            )
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewShimmer() {
    Shimmer()
}