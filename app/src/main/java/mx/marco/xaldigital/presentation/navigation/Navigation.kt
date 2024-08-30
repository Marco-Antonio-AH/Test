package mx.marco.xaldigital.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.marco.xaldigital.presentation.screens.splash.SplashScreen
import mx.marco.xaldigital.presentation.screens.history.HistoryScreen
import mx.marco.xaldigital.presentation.screens.home.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.SPLASH
    ) {
        composable(Screens.HOME) {
            HomeScreen(navController)
        }

        composable(Screens.SPLASH) {
            SplashScreen(navController)
        }

        composable(Screens.HISTORY) {
            HistoryScreen(navController)
        }
    }
}