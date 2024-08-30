package mx.marco.xaldigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mx.marco.xaldigital.domain.preferences.Preferences
import mx.marco.xaldigital.presentation.navigation.Navigation
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
                Navigation(navController = navController)
            }
        }
    }
}





