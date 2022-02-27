package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ahmedmamdouh13.ama.qurbacomposedemo.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = FontColorTitleBlack
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = FontColorTitleBlack
    )
    ,h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = FontColorTitleBlack
    )
    ,h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = FontColorTitleBlack
    )
    ,h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = FontColorTitleBlack
    )
    ,subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = FontColorSubtitleGrayOpacity50
    )
    ,subtitle2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        color = FontColorSubtitleGray
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ), */
            ,
    caption = TextStyle(
        fontFamily =  FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)