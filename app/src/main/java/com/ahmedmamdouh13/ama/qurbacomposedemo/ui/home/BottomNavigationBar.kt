package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.presentation.model.home.BottomNavigationStateType
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.*


@Composable
fun BottomNavigationBar(bottomNavigationState: MutableState<BottomNavigationStateType>) {
    val shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)

    Box(
        modifier = Modifier
            .clip(shape)
            .fillMaxWidth()
            .wrapContentHeight()
            .height(dimensionResource(id = R.dimen.barHeight))
            .shadow(1.dp, shape)
            .offset(y = (2).dp)
            .background(
                color = Color.White,
                shape = shape
            )
    ) {

        Row(
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.padding_16))
                .height(dimensionResource(id = R.dimen.barHeight))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            HomeIcon(bottomNavigationState)
            RestaurantIcon(bottomNavigationState)
            OfferIcon(bottomNavigationState)
            AccountIcon(bottomNavigationState)
            ProfileIcon(bottomNavigationState)


        }

    }

}

@Composable
fun IndicatorIcon(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = EnterTransition.None,
        exit = ExitTransition.None
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(
                    shape = RoundedCornerShape(20.dp),
                    brush = Brush.linearGradient(colors = listOf(Indigo, Fuchsia))
                ).clip(RoundedCornerShape(20.dp))

        )

    }
}

@Composable
fun AccountIcon(state: MutableState<BottomNavigationStateType>) {
    NavigationIcon(
        accountRes,
        BottomNavigationStateType.ACCOUNT, state
    )
}


@Composable
fun ProfileIcon(state: MutableState<BottomNavigationStateType>) {
    NavigationIcon(
        profileRes,
        BottomNavigationStateType.PROFILE, state
    )
}


@Composable
fun OfferIcon(state: MutableState<BottomNavigationStateType>) {
    NavigationIcon(
        offerRes,
        BottomNavigationStateType.OFFER, state
    )
}


@Composable
fun RestaurantIcon(state: MutableState<BottomNavigationStateType>) {
    NavigationIcon(
        restaurantRes,
        BottomNavigationStateType.RESTAURANT, state
    )
}

@Composable
fun HomeIcon(state: MutableState<BottomNavigationStateType>) {
    NavigationIcon(
        homeRes,
        BottomNavigationStateType.HOME, state
    )
}


@Composable
fun NavigationIcon(
    drawableRes: Int,

    stateType: BottomNavigationStateType,
    state: MutableState<BottomNavigationStateType>
) {
    val isActive = state.value == stateType

    Box(modifier = Modifier
        .size(40.dp)
        .clip(RoundedCornerShape(20.dp))
        .clickable {
            state.value = stateType
        }, contentAlignment = Alignment.Center
    ) {

        IndicatorIcon(isActive)

        Image(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center), painter = painterResource(id = drawableRes),
            contentDescription = "search", contentScale = ContentScale.Inside,
            colorFilter = if (isActive) ColorFilter.tint(Color.White) else null
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewBottomNavigationBar() {
//    BottomNavigationBar(homeViewModel.bottomNavigationState)
}