package mx.marco.xaldigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mx.marco.xaldigital.domain.preferences.Preferences
import mx.marco.xaldigital.presentation.screens.history.HistoryScreen
import mx.marco.xaldigital.presentation.screens.home.HomeScreen
import mx.marco.xaldigital.presentation.theme.XalDigitalTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            XalDigitalTheme(darkTheme = preferences.loadDarkTheme()) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { SplashScreen(navController) }
                    composable("home") { HomeScreen(navController) }
                    composable("history") { HistoryScreen(navController) }
                }

            }
        }
    }
}





