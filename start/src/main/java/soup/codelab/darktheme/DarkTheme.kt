package soup.codelab.darktheme

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate

object DarkTheme {

    fun apply(enabled: Boolean = false) {
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

    fun isEnabled(context: Context): Boolean {
        return context.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK ==
                Configuration.UI_MODE_NIGHT_YES
    }
}
