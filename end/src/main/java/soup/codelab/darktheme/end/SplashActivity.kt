package soup.codelab.darktheme.end

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        window.decorView.postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 300
        )
    }
}
