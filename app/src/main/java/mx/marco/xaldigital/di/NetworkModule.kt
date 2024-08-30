package mx.marco.xaldigital.di

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.marco.xaldigital.BuildConfig
import mx.marco.xaldigital.data.remote.XalDigitalApiService
import mx.marco.xaldigital.util.encodeBase64
import mx.marco.xaldigital.util.hasInternetConnection
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNationalizeApi(): XalDigitalApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(XalDigitalApiService::class.java)
    }
}

fun getAsyncImageLoader(context: Context): ImageLoader {
    val client =
        createAuthenticatedClient(BuildConfig.BASE_USER, BuildConfig.BASE_PASSWORD, context)
    return ImageLoader
        .Builder(context)
        .okHttpClient(client)
        .memoryCache (newMemoryCache(context))
        .diskCache(newDiskCache(context))
        .networkCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .allowRgb565(true) // Mejora el uso de memoria
        .logger(DebugLogger())
        .crossfade(true)
        .build()
}


fun newMemoryCache(context: Context): MemoryCache =
    MemoryCache.Builder(context)
        .maxSizePercent(0.25)
        .build()

fun newDiskCache(context: Context): DiskCache =
    DiskCache
        .Builder()
        .directory(context.cacheDir.resolve("image_cache"))
        .maxSizePercent(0.02)
        .build()


fun createAuthenticatedClient(username: String, password: String, context: Context): OkHttpClient {
    val credentials = "$username:$password"
    val authToken = "Basic ${encodeBase64(credentials)}"

    // Directorio de caché
    val cacheSize = 10 * 1024 * 1024 // 10 MB
    val cacheDirectory = File(context.cacheDir, "http_cache")
    val cache = Cache(cacheDirectory, cacheSize.toLong())

    return OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor { chain ->
            var request = chain.request()
            // Agrega el encabezado de autorización
            request = request.newBuilder()
                .addHeader("Authorization", authToken)
                .build()
            chain.proceed(request)
        }
        .addNetworkInterceptor { chain ->
            val response = chain.proceed(chain.request())
            // Configura la caché para la respuesta de la red
            response.newBuilder()
                .header("Cache-Control", "public, max-age=" + 60) // 1 minuto de caché en red
                .build()
        }
        .addInterceptor { chain ->
            var request = chain.request()
            // Forzar el uso de caché si no hay conexión a Internet
            if (!hasInternetConnection(context)) {
                request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7) // 1 semana de caché
                    .build()
            }
            chain.proceed(request)
        }
        .build()
}

