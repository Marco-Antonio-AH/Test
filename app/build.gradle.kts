plugins {
    id(BuildConfig.ANDROID_APPLICATION)
    id(Kotlin.plugin)
    id(DaggerHilt.plugin)
    id(Kotlin.kaptPlugin)
    id(Kotlin.parcelize)
    //id(Firebase.plugin)
    //id(Firebase.pluginCrashlytics)
}

android {
    namespace = ProjectConfig.APP_ID
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        applicationId = ProjectConfig.APP_ID
        minSdk = ProjectConfig.MIN_SDK
        targetSdk = ProjectConfig.TARGET_SDK
        versionCode = ProjectConfig.VERSION_CODE
        versionName = ProjectConfig.getVersionName()

        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"${ProjectConfig.BASE_URL_DEV}\"")
            buildConfigField("String", "BASE_USER", "\"${ProjectConfig.BASE_USER_DB}\"")
            buildConfigField("String", "BASE_PASSWORD", "\"${ProjectConfig.BASE_PASSWORD_DB}\"")
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"${ProjectConfig.BASE_URL_PROD}\"")
            buildConfigField("String", "BASE_USER", "\"${ProjectConfig.BASE_USER_DB}\"")
            buildConfigField("String", "BASE_PASSWORD", "\"${ProjectConfig.BASE_PASSWORD_DB}\"")
        //signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Kotlin.extensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleRuntimeKtx)

    implementation(Compose.activityCompose)
    implementation(platform(Compose.composeBom))
    implementation(Compose.composeUi)
    implementation(Compose.composeGraphics)
    implementation(Compose.composeToolingPreview)
    implementation(Compose.composeMaterial3)
    implementation(Compose.composeLifecycleViewModel)
    implementation(Compose.composeNavigation)
    implementation(Compose.composeLifecycle)
    implementation(Compose.composeHiltNavigation)
    debugImplementation(Compose.composeUiTooling)
    debugImplementation(Compose.composeTestManifest)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    implementation(Retrofit.retrofit)
    implementation(Retrofit.gsonConverter)
    implementation(platform(Retrofit.okHttpBom))
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)

    //implementation(Maps.mapsCompose)
    //implementation(Maps.playServicesMaps)

    implementation(Coil.coilCompose)

    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)
    implementation(Room.roomRuntime)

    //implementation(Location.playServicesLocation)
    //implementation(Location.placesApi)

    //implementation(platform(Firebase.firebaseBom))
    //implementation(Firebase.analytics)
    //implementation(Firebase.crashlytics)

    testImplementation(Testing.junit4)
    androidTestImplementation(Testing.extJunit)
    androidTestImplementation(Testing.espresso)
    androidTestImplementation(platform(Testing.composeBomTesting))
    androidTestImplementation(Testing.composeUiTesting)

    // For media playback using ExoPlayer
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)

    //COLOR STATUS BAR
    implementation (libs.accompanist.systemuicontroller)

    //Coil
    implementation (libs.coil.compose)

}