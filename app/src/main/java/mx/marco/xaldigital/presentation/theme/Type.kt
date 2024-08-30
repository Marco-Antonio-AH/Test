package mx.marco.xaldigital.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import mx.marco.xaldigital.R


val fontNormal = FontFamily(
    Font(
        R.font.changa_variable_font_wght
    )
)
val textStyle = TextStyle(
    fontFamily = fontNormal,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.5.sp
)


val Typography = Typography(
    titleLarge = textStyle.copy(
        fontSize = 55.sp,
        lineHeight = 24.sp
    ),
    bodyLarge = textStyle.copy(
        fontSize = 30.sp,
        lineHeight = 24.sp
    ),

    bodyMedium = textStyle.copy(
        fontSize = 20.sp,
        lineHeight = 18.sp
    ),
    bodySmall = textStyle.copy(
        fontSize = 19.sp,
        lineHeight = 16.sp
    ),
    labelLarge = textStyle.copy(
        fontWeight = FontWeight(300),
        fontSize = 15.sp,
        lineHeight = 15.sp
    ),
    labelMedium = textStyle.copy(
        fontWeight = FontWeight(700),
        fontSize = 13.sp,
        lineHeight = 13.sp
    ),
    labelSmall = textStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 8.sp
    )

)


fun Typography.defaultFontFamily(fontFamily: FontFamily, colorScheme: ColorScheme): Typography {
    return this.copy(
        displayLarge = this.displayLarge.copy(fontFamily = fontFamily, color = colorScheme.primary),
        displayMedium = this.displayMedium.copy(
            fontFamily = fontFamily,
            color = colorScheme.primary
        ),
        displaySmall = this.displaySmall.copy(fontFamily = fontFamily, color = colorScheme.primary),
        headlineLarge = this.headlineLarge.copy(
            fontFamily = fontFamily,
            color = colorScheme.primary
        ),
        headlineMedium = this.headlineMedium.copy(
            fontFamily = fontFamily,
            color = colorScheme.primary
        ),
        headlineSmall = this.headlineSmall.copy(
            fontFamily = fontFamily,
            color = colorScheme.primary
        ),
        titleLarge = this.titleLarge.copy(fontFamily = fontFamily, color = colorScheme.primary),
        titleMedium = this.titleMedium.copy(fontFamily = fontFamily, color = colorScheme.primary),
        titleSmall = this.titleSmall.copy(fontFamily = fontFamily, color = colorScheme.primary),
        bodyLarge = this.bodyLarge.copy(fontFamily = fontFamily, color = colorScheme.primary),
        bodyMedium = this.bodyMedium.copy(fontFamily = fontFamily, color = colorScheme.primary),
        bodySmall = this.bodySmall.copy(fontFamily = fontFamily, color = colorScheme.primary),
        labelLarge = this.labelLarge.copy(fontFamily = fontFamily, color = colorScheme.primary),
        labelMedium = this.labelMedium.copy(fontFamily = fontFamily, color = colorScheme.primary),
        labelSmall = this.labelSmall.copy(fontFamily = fontFamily, color = colorScheme.primary)
    )
}