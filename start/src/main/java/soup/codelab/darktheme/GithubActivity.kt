package soup.codelab.darktheme

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import soup.codelab.darktheme.databinding.GithubActivityBinding

class GithubActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GithubActivityBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = HelpClient()
            webView.loadUrl(GITHUB_URL)
        }
    }

    private class HelpClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return url != GITHUB_URL
        }
    }

    companion object {

        private const val GITHUB_URL = "https://github.com/fornewid/Android-DarkTheme-CodeLab"
    }
}
