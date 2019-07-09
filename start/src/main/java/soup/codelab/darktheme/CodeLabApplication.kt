package soup.codelab.darktheme

import android.app.Application

class CodeLabApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DarkTheme.apply()
    }
}