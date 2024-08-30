package mx.marco.xaldigital.presentation.composables.images

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import mx.marco.xaldigital.R


import mx.marco.xaldigital.di.getAsyncImageLoader

@Composable
fun ImageNormal(
    modifier: Modifier = Modifier,
    imageName: String,
    contentScale: ContentScale = ContentScale.Fit,
    authenticate: Boolean = false
) {
    if (authenticate) {
        val context = LocalContext.current
        val imageLoader = remember { getAsyncImageLoader(context) }

        AsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageName)
                .diskCacheKey(imageName) // Utiliza una clave de caché única
                .memoryCacheKey(imageName) // Utiliza una clave de caché en memoria única
                .networkCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .build(),
            contentDescription = null,
            contentScale = contentScale,
            imageLoader = imageLoader,
            placeholder = painterResource(R.drawable.loading)
        )
    } else {
        AsyncImage(
            modifier = modifier,
            model = imageName,
            contentDescription = null,
            contentScale = contentScale,
            placeholder = painterResource(R.drawable.loading)
        )
    }
}