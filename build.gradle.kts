// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id(BuildConfig.ANDROID_APPLICATION) version BuildConfig.ANDROID_APPLICATION_VERSION apply false
    id(Kotlin.plugin) version Kotlin.version apply false
    id(DaggerHilt.plugin) version DaggerHilt.version apply false
    //id(Firebase.plugin) version Firebase.pluginVersion apply false
    //id(Firebase.pluginCrashlytics) version Firebase.pluginCrashlyticsVersion apply false
}