package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.post.content

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


private const val defaultImageContentHeight = 192
private const val paddingSize = 4
private val displayMetrics = Resources.getSystem().displayMetrics

@Composable
fun GridContentImages(images: List<String>) {
    val defaultImageContentWidth = (displayMetrics.widthPixels / displayMetrics.density) / 2

    var minImageWidthSize = defaultImageContentWidth
    var height = defaultImageContentHeight

    //if there is only one image, make it full width, otherwise, calculate other images height.
    if (images.size > 1) height = calculateGridItemsHeight(images.size, paddingSize)
    else minImageWidthSize = (displayMetrics.widthPixels / displayMetrics.density)


    Row {
        Image(
            modifier = Modifier
                .width(minImageWidthSize.dp)
                .height(defaultImageContentHeight.dp),
            painter = rememberImagePainter(data = images[0]),
            contentDescription = "",
            contentScale = ContentScale.Crop

        )
        Spacer(modifier = Modifier.padding(start = paddingSize.dp))
        Column {
            for (i in 1 until images.size) {
                if (i != 1)
                    Spacer(modifier = Modifier.padding(top = paddingSize.dp))
                Image(
                    modifier = Modifier
                        .height(height.dp)
                        .width(minImageWidthSize.dp),
                    painter = rememberImagePainter(data = images[i]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

    }


}

//calculate height for grid items, minding padding
fun calculateGridItemsHeight(itemCount: Int, paddingSize: Int): Int {
    return ((defaultImageContentHeight - ((itemCount - 2) * paddingSize)) / (itemCount - 1))
}
