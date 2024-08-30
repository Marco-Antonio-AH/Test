package mx.marco.xaldigital.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import mx.marco.xaldigital.R


private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = OnSecondary,
    primaryContainer = PrimaryVariant,
    onPrimaryContainer = Secondary,
    secondary = Secondary,
    onSecondary = OnPrimary,
    secondaryContainer = SecondaryVariant,
    background = OnBackground,
    onBackground = Background,
    surface = Surface,
    onSurface = OnSurface,
    error = Color.Red,
    onError = Secondary
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryVariant,
    onPrimaryContainer = Secondary,
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryVariant,
    background = Background,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface,
    error = Color.Red,
    onError = Secondary

)

@Composable
fun XalDigitalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val typography = Typography().defaultFontFamily(FontFamily(Font(R.font.changa_variable_font_wght)), colorScheme)

    MaterialTheme(
        content = content,
        typography = typography,
        colorScheme = colorScheme
    )
}

fun ColorScheme.darkColorTheme(): ColorScheme {
    return this.copy(
        primary = Primary,
        surface = Surface,
        onSurface = OnSurface
    )
}
