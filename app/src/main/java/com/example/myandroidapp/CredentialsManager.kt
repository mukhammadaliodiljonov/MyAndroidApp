package com.example.myandroidapp

object CredentialsManager {
    private const val VALID_EMAIL = "test@te.st"
    private const val VALID_PASSWORD = "1234"

    fun validateCredentials(email: String, password: String): Boolean {
        return email == VALID_EMAIL && password == VALID_PASSWORD
    }
}