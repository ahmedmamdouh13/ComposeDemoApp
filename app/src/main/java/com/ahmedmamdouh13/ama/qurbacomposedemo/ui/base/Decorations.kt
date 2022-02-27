package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun StartEndPadding(startEndPadding: Dp, item: @Composable () -> Unit) {
    Box(
        modifier = Modifier.padding(
            start = startEndPadding,
            end = startEndPadding
        )
    ) {
        item()
    }
}
