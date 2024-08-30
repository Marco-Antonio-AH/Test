package mx.marco.xaldigital.presentation.composables.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import mx.marco.xaldigital.R


@Composable
fun CustomTopBar(
    buttonBack: Boolean = true,
    title: Int? = null,
    profileIcon: Int? = null,
    iconColors: Color = MaterialTheme.colorScheme.primary
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .padding(start = 20.dp)
                .weight(1f)
        ) {
            if (buttonBack) {
                IconButton(modifier = Modifier,
                    onClick = { /*navController.popBackStack() */}) {

                }
            }
        }

        Box(
            modifier = Modifier
                .padding(start = 30.dp)
                .weight(1f)
        ) {
            if (profileIcon != null) {
                AsyncImage(
                    modifier = Modifier.clip(RoundedCornerShape(50.dp)),
                    model = R.drawable.menu,
                    contentDescription = null
                )
            }
        }
    }
}
