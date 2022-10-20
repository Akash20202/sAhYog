package com.example.sahyog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var txtName : EditText
    private lateinit var txtEmail : EditText
    private lateinit var txtCity : EditText
    private lateinit var txtID : EditText
    private lateinit var txtIDNumber : EditText
    private lateinit var txtPwd : EditText
    private lateinit var txtConfirmPwd : EditText
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        txtName = findViewById(R.id.txtName)
        txtEmail = findViewById(R.id.txtEmail)
        txtCity = findViewById(R.id.txtCity)
        txtID = findViewById(R.id.txtID)
        txtIDNumber = findViewById(R.id.txtIDNumber)
        txtPwd = findViewById(R.id.txtPwd)
        txtConfirmPwd = findViewById(R.id.txtConfirmPwd)
        auth = FirebaseAuth.getInstance()
    }
    fun back(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun Register(view: View) {
        val email = txtEmail.text.toString()
        val pass = txtPwd.text.toString()
        val confirmPassword = txtConfirmPwd.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }
        if(pass.length<8){
            Toast.makeText(this, "Password is minimum of 8 character", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val intent = Intent(this,Dashboard::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }