package mx.marco.xaldigital.presentation.screens.history


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import mx.marco.xaldigital.presentation.composables.screens.Screen

import mx.nancrow.xaldigital.presentation.composables.CardGeneral

@Composable
fun HistoryScreen(
    navController: NavController,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val uiState = viewModel.state
    val scrollState = rememberScrollState()



    Screen(
        paddingTop = false,
        iconColors = MaterialTheme.colorScheme.secondary,
        colorStatusBar = MaterialTheme.colorScheme.primary,
        darkIconsStatusBar = false
    ) {


        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier
                    .padding(top = 28.dp),
                    text = "Historial de búsqueda")
                uiState.recordWithProbability.forEach {
                    val formattedText =
                        it.probabilities.joinToString(separator = "\n\n") { country ->
                            "Id del país: ${country.countryId}, \nProbabilidad: \n${country.probability}"
                        }
                    val format = "${it.record.name}\n$formattedText"
                    Spacer(modifier = Modifier.height(30.dp))
                    CardGeneral(
                        modifier = Modifier
                            .fillMaxWidth(.54f)
                            .fillMaxHeight()

                    ) {
                        Text(
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .offset(x = (10).dp, y = (10).dp),
                            text = format
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }

            }
        }

    }


}



