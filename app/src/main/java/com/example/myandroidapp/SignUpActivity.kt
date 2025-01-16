package com.example.myandroidapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.widget.CheckBox
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val fullName: TextInputEditText = findViewById(R.id.fullName)
        val validEmail: TextInputEditText = findViewById(R.id.validEmail)
        val phoneNumber: TextInputEditText = findViewById(R.id.phoneNumber)
        val strongPassword: TextInputEditText = findViewById(R.id.strongPassword)
        val agreementCheck: CheckBox = findViewById(R.id.agreementCheck)
        val btnNext: Button = findViewById(R.id.btnNext)
        val tvRegisterNow: TextView = findViewById(R.id.tvRegisterNow)

        btnNext.setOnClickListener {
            // Handle sign-up validation here
        }

        tvRegisterNow.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
