package mx.marco.xaldigital.presentation.screens.home


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import mx.marco.xaldigital.presentation.composables.screens.Screen
import mx.marco.xaldigital.presentation.navigation.Screens
import mx.nancrow.xaldigital.presentation.composables.CardGeneral

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState = viewModel.state
    val scrollState = rememberScrollState()
    val formattedText = uiState.user.country.joinToString(separator = "\n\n") { country ->
        "Id del país: ${country.countryId}, \nProbabilidad: \n${country.probability}"
    }


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
                    .fillMaxHeight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier
                    .padding(top = 22.dp),
                    text = "Búsqueda")
                Spacer(modifier = Modifier.fillMaxHeight(.03f))

                OutlinedTextField(
                    value = uiState.searchText,
                    modifier = Modifier,
                    onValueChange = { newValue ->
                        viewModel.onEvent(HomeViewEvent.OnSearchTextChange(newValue))
                    },
                    shape = RoundedCornerShape(12.dp),

                    label = { Text("Ingrese un nombre") }
                )
                Spacer(modifier = Modifier.fillMaxHeight(.08f))
                Button(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(.4f),
                    onClick = {
                        viewModel.onEvent(HomeViewEvent.OnSearchButtonClicked)
                    }) {
                    Text(text = "Predecir", color = Color.Black)
                }
                Spacer(modifier = Modifier.fillMaxHeight(.08f))
                CardGeneral(
                    modifier = Modifier
                        .fillMaxWidth(.54f)
                        .fillMaxHeight(.68f)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        modifier = Modifier
                            .offset(x = (8).dp,)
                            .wrapContentHeight()
                            .verticalScroll(scrollState),
                        text = formattedText
                    )
                }
                Spacer(modifier = Modifier.fillMaxHeight(.09f))


                Button(modifier = Modifier
                    .fillMaxWidth(.4f),
                    onClick = {
                        navController.navigate(Screens.HISTORY)
                    }) {
                    Text(text = "Ver historial", color = Color.Black)
                }
            }
        }

    }
}



