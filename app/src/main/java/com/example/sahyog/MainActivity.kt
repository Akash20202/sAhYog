package com.example.sahyog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var userName : EditText
    private lateinit var Pwd : EditText
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userName = findViewById(R.id.userName)
        Pwd = findViewById(R.id.Pwd)
        auth = FirebaseAuth.getInstance()
    }
    fun Signup(view: View) {
        val intent = Intent(this, Register::class.java);
        startActivity(intent)
        finish();
    }

    fun signin(view: View) {
        val email=userName.text.toString()
        val password=Pwd.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent = Intent(this,Dashboard::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}