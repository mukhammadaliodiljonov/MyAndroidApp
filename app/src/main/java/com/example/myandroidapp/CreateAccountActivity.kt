package com.example.myandroidapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView


class CreateAccountActivity : AppCompatActivity() {

    // Properties for Views
    private val emailInputLayout: TextInputLayout by lazy { findViewById(R.id.textInputEmail) }
    private val passwordInputLayout: TextInputLayout by lazy { findViewById(R.id.textInputPassword) }
    private val emailEditText: TextInputEditText by lazy { findViewById(R.id.etEmail) }
    private val passwordEditText: TextInputEditText by lazy { findViewById(R.id.etPassword) }
    private val rememberMeCheckBox: CheckBox by lazy { findViewById(R.id.cbRememberMe) }
    private val nextButton: Button by lazy { findViewById(R.id.btnNext) }
    private val forgotPasswordTextView: TextView by lazy { findViewById(R.id.tvForgotPassword) }
    private val registerNowTextView: TextView by lazy { findViewById(R.id.tvRegisterNoww) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        setupListeners()
    }

    private fun setupListeners() {
        nextButton.setOnClickListener { validateAndLogin() }
        registerNowTextView.setOnClickListener { navigateToSignUpActivity() }
    }

    private fun validateAndLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        var isValid = true

        // Email Validation
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInputLayout.error = "Invalid email address"
            isValid = false
        } else {
            emailInputLayout.error = null
        }

        // Password Validation
        if (password.isEmpty() || password.length < 4) {
            passwordInputLayout.error = "Password must be at least 4 characters"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

        // Check Credentials
        if (isValid) {
            if (CredentialsManager.validateCredentials(email, password)) {
                navigateToMainActivity()
            } else {
                passwordInputLayout.error = "Incorrect email or password"
            }
        }
    }

    private fun navigateToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
