package com.example.teayudaapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val BlueBack = Color(0xFF7286D3)
private val BluePrimary = Color(0xFF8EA7E9)
private val DeepBlue = Color(0xFF01002E)
private val SmoothWhite = Color(0xFFFFF2F2)
//private val InputBlue = Color(0xFF262763)

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = BlueBack
)

//TODO: We need to add more colors from the specific colors palette (See Figma project)
private val LightColorPalette = lightColors(
    primary = BluePrimary,
    primaryVariant = SmoothWhite,
    secondary = Teal200,
    onSecondary = DeepBlue,
    background = BlueBack,
    onSurface = Color.White,
    onBackground = DeepBlue,
    onPrimary = Color.LightGray,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TEAyudaAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}