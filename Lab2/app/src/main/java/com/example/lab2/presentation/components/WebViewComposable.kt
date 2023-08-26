package com.example.lab2.presentation.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewComposable(url: String, onClose: () -> Unit) {
    val context = LocalContext.current
    val webView = remember { WebView(context) }
    webView.webViewClient = WebViewClient()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = { webView },
            update = { it.loadUrl(url) }
        )
        Button(
            onClick = onClose,
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(15.dp)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Close", fontSize = 18.sp)
        }
    }
}
