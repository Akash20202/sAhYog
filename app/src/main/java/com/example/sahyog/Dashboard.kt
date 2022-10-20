package com.example.sahyog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun suitable(view: View) {
        val intent = Intent(this,Suitablecrop::class.java)
        startActivity(intent)
    }

    fun rabi(view: View) {}
    fun Weather(view: View) {}
}