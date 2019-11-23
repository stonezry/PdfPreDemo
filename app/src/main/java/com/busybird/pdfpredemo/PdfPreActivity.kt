package com.busybird.pdfpredemo

import android.net.Uri
import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pdf_js.*


class PdfPreActivity : AppCompatActivity() {

    var type = 0
    var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        intent.also {
            type = it.getIntExtra("type",0)
            url = it.getStringExtra("url")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_js)
        initWebview()
        if (type == 1){
            webview.loadUrl("file:///android_asset/pdfJs/web/viewer.html?file=file:///android_asset/" +
                    Uri.encode(url, "UTF-8"))
        }else if(type == 2){
            webview.loadUrl("file:///android_asset/pdfJs/web/viewer.html?file==file://" + url)

        }else if(type ==3){
            webview.loadUrl("file:///android_asset/pdfJs/web/viewer.html?file=" + url)
        }
    }

    fun initWebview(){
        val webSettings: WebSettings = webview.settings
        webSettings.javaScriptEnabled = true

        webSettings.pluginState = WebSettings.PluginState.ON
        webSettings.allowContentAccess = true
        webSettings.allowFileAccess = true
        webSettings.allowFileAccessFromFileURLs = true
        /**
         * 简单来说，该项设置决定了JavaScript能否访问来自于任何源的文件标识的URL。
         * 比如我们把PDF.js放在本地assets里，然后通过一个URL跳转访问来自于任何URL的PDF，所以这里我们需要将其设置为true。
         * 而一般情况下，为了安全起见，是需要将其设置为false的。
         */
        webSettings.allowUniversalAccessFromFileURLs = true
    }


}
