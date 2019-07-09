package soup.codelab.darktheme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.postDelayed

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        window.decorView.postDelayed(300) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
