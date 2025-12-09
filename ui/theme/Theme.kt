package com.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// 🌙 Esquema de Colores Oscuro (DarkColorScheme)
private val DarkColorPalette = darkColorScheme(
    primary = SimpsonsYellow,
    onPrimary = TextLight, // Texto sobre el amarillo
    secondary = SimpsonsBlue,
    onSecondary = TextDark,
    background = BackgroundDark,
    onBackground = TextDark,
    surface = SurfaceDark,
    onSurface = TextDark,
    error = ErrorColor,
    onError = TextDark
)

// ☀️ Esquema de Colores Claro (LightColorScheme)
private val LightColorPalette = lightColorScheme(
    primary = SimpsonsYellow,
    onPrimary = TextLight, // Texto sobre el amarillo
    secondary = SimpsonsBlue,
    onSecondary = TextDark,
    background = BackgroundLight,
    onBackground = TextLight,
    surface = SurfaceLight,
    onSurface = TextLight,
    error = ErrorColor,
    onError = TextDark
)

@Composable
fun TheSimpSomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {

        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}