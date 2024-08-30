object ProjectConfig {
    const val APP_ID = "mx.marco.xaldigital"
    const val COMPILE_SDK = 34
    const val MIN_SDK = 26
    const val TARGET_SDK = 34

    const val VERSION_CODE = 1
    private const val VERSION_MAJOR = 1
    private const val VERSION_MINOR = 2
    private const val VERSION_PATCH = 0

    fun getVersionName(): String {
        return "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"
    }

    //BuildConfig create base url
    const val BASE_URL_DEV = "https://api.nationalize.io"
    const val BASE_URL_PROD = "https://api.nationalize.io"

    //BuildConfig create base url
    const val BASE_USER_DB = "admin"
    const val BASE_PASSWORD_DB = "123456"

}