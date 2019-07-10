package soup.codelab.darktheme.end

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import soup.codelab.darktheme.end.databinding.WebActivityBinding

class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WebActivityBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = HelpClient()
            webView.loadUrl(WHALE_URL)
        }
    }

    private class HelpClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return url != WHALE_URL
        }
    }

    companion object {

        private const val WHALE_URL = "https://m.whale.naver.com/en/"
    }
}
