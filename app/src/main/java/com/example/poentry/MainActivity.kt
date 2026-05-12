package com.example.poentry

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.poentry.ui.theme.PoEntryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PoEntryTheme {
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            settings.apply {
                                javaScriptEnabled = true
                                domStorageEnabled = true
                                loadWithOverviewMode = true
                                useWideViewPort = true
                                setSupportZoom(false)
                                builtInZoomControls = false
                                displayZoomControls = false
                            }
                            webViewClient = WebViewClient()
                            loadUrl("file:///android_asset/www/index.html")
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}