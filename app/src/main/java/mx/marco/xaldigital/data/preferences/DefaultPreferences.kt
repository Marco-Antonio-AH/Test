package mx.marco.xaldigital.data.preferences

import android.content.SharedPreferences
import mx.marco.xaldigital.domain.preferences.Preferences


class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun isDarkTheme(darkTheme: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.IS_DARK_THEME, darkTheme)
            .apply()
    }

    override fun loadDarkTheme(): Boolean {
        return sharedPref
            .getBoolean(Preferences.IS_DARK_THEME, false)
    }
}