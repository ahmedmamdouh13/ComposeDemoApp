package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.model.post.promo.PromoModel
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.BorderColorBlack
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.PromoActionButtonTextColor
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.Typography

@Composable
fun Promo(model: PromoModel, onClickActionButton: (PromoModel) -> Unit) {
    Column(

    ) {

        Row(
            modifier = Modifier
                .wrapContentSize()

        ) {


            ProfilePicture(model.vendorPic)

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {

                ProfileHeader(userName = model.vendorPromoTitle, isVendor = true)


                Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_6)))

                Text(
                    text = model.vendorPromoSubtitle,
                    style = Typography.subtitle2
                )


            }

        }

        if (model.isActionNeeded) {
            Spacer(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_10)))
            ActionButton(model, onClick = onClickActionButton)
        }

    }

}

@Composable
fun ActionButton(model: PromoModel, onClick: (PromoModel) -> Unit) {

    val brush = Brush.linearGradient(
        Pair(0.4f, colorResource(id = R.color.indigo_gradient_A36)),
        Pair(0.8f, colorResource(id = R.color.fuchsia_gradient_A36)),
    )


    TextButton(
        onClick = { onClick(model) },
        modifier = Modifier
            .background(brush, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(32.dp)

    ) {

        Text(
            text = model.actionButtonText,
            color = PromoActionButtonTextColor,
            style = Typography.subtitle1,
            fontSize = 14.sp
        )


    }

}