package soup.codelab.darktheme

import androidx.appcompat.app.AppCompatDelegate

object DarkTheme {

    private var isEnabled = false

    fun apply(enabled: Boolean = isEnabled) {
        if (isEnabled == enabled) return
        isEnabled = enabled
        val nightMode = if (enabled) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    fun isEnabled(): Boolean {
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
    }
}
