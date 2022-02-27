package com.ahmedmamdouh13.ama.qurbacomposedemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.res.colorResource
import com.ahmedmamdouh13.ama.qurbacomposedemo.R

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

//Ripple
private object RippleCustomTheme: RippleTheme {

    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            colorResource(id = R.color.fuchsia_gradient),
            lightTheme = true
        )

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(
            colorResource(id = R.color.indigo_gradient),
            lightTheme = true
        )
}


@Composable
fun QurbaComposeDemoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = {
                CompositionLocalProvider(LocalRippleTheme provides RippleCustomTheme) {
                    content()
                }
            }
        )

}