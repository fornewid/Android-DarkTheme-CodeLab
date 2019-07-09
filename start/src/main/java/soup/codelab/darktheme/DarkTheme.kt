package soup.codelab.darktheme

import android.app.UiModeManager
import android.content.Context
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

    fun isEnabled(context: Context): Boolean {
        return context.resources.configuration.uiMode and
                UiModeManager.MODE_NIGHT_YES ==
                UiModeManager.MODE_NIGHT_YES
    }
}
