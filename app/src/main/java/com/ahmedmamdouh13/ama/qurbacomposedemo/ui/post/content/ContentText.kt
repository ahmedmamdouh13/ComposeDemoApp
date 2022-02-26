package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme.Typography

@Composable
fun ContentText(text: String) {
    Text(text = text, style = Typography.body1, fontSize = 12.sp)
}
