package com.forestguard.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryNeonGreen,
    secondary = DeepGreenContainer,
    tertiary = RiskMedium,
    background = DarkGreenBackground,
    surface = DeepGreenContainer,
    onPrimary = Color.Black,
    onSecondary = TextWhite,
    onTertiary = Color.Black,
    onBackground = TextWhite,
    onSurface = TextWhite,
    error = AccentRedAlert
)

@Composable
fun ForestGuardTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
