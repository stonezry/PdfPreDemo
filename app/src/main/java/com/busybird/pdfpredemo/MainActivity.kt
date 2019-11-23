package com.busybird.pdfpredemo

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLister()

        //检测是否有写的权限
        val permission = ActivityCompat.checkSelfPermission(this,"android.permission.WRITE_EXTERNAL_STORAGE")
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // 没有写的权限，去申请写的权限，会弹出对话框
            ActivityCompat.requestPermissions(this, arrayOf("android.permission.WRITE_EXTERNAL_STORAGE"),0)
        }
    }


    fun initLister(){
        pdf_from_assets.setOnClickListener{

            val intent = Intent(this,PdfPreActivity::class.java)
            intent.putExtra("type",1)
            intent.putExtra("url","PlayerAPI_v1.0.6.pdf")
            startActivity(intent)

        }
        pdf_from_scard.setOnClickListener{

            val intent = Intent(this,PdfPreActivity::class.java)
            intent.putExtra("type",2)
            intent.putExtra("url","sdcard pdf地址")
            startActivity(intent)

        }

        pdf_from_url.setOnClickListener {
            val intent = Intent(this,PdfPreActivity::class.java)
            intent.putExtra("type",3)
            intent.putExtra("url","http://storage.xuetangx.com/public_assets/xuetangx/PDF/PlayerAPI_v1.0.6.pdf")
            startActivity(intent)
        }
    }
}
