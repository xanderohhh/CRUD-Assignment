package com.example.crudassignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun imgViewOnClick( v: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun btnSupportOnClick( v: View){
        val uri: Uri = Uri.parse("https://stinkyboys.club/contact")
        val intent = Intent( Intent.ACTION_VIEW, uri )
        startActivity(intent)
    }

    fun btnAboutOnClick( v: View){
        val uri: Uri = Uri.parse("https://stinkyboys.club")
        val intent = Intent( Intent.ACTION_VIEW, uri )
        startActivity(intent)
    }
}