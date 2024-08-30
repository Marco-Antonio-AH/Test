package mx.marco.xaldigital.presentation.composables.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Screen(
    buttonBack: Boolean = true,
    title: Int? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    colorStatusBar: Color = MaterialTheme.colorScheme.surface,
    darkIconsStatusBar: Boolean = false,
    paddingTop: Boolean = true,
    iconColors: Color = MaterialTheme.colorScheme.primary,
    content: @Composable BoxScope. () -> Unit
) {
    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = colorStatusBar,
//            darkIcons = darkIconsStatusBar
//        )
//    }
    Scaffold(
        topBar = {
            CustomTopBar(
                buttonBack = buttonBack,
                title = title,
                iconColors = iconColors
            )
        },
        containerColor = containerColor
    ) {
        Box(
            modifier = Modifier
                .padding(
                    if (paddingTop) {
                        it
                    } else {
                        PaddingValues()
                    }
                )
                .fillMaxSize()
        ) {
            content()
        }
    }
}