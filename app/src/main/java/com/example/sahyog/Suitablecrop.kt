package com.example.sahyog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Suitablecrop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suitablecrop)
    }

    fun rabi(view: View) {
        val intent = Intent(this,rabi::class.java)
        startActivity(intent)
    }

    fun kharib(view: View) {
        val intent = Intent(this,kharif::class.java)
        startActivity(intent)
    }

    fun zaid(view: View) {
        val intent = Intent(this,zaid::class.java)
        startActivity(intent)
    }
}