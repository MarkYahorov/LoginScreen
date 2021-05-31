package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var loginText: EditText
    private lateinit var passwordText: EditText
    private lateinit var registerBtn: Button
    private lateinit var loginBtn: Button

    private val login = "admin"
    private val password = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        find()
        registerOrLoginPerson()
    }

    private fun find() {
        loginText = findViewById(R.id.login)
        passwordText = findViewById(R.id.password)
        registerBtn = findViewById(R.id.regBtn)
        loginBtn = findViewById(R.id.logBtn)
    }

    private fun checkErrorsInLoginAndPasswordEditText(): Boolean {

        if (loginText.text.toString() != login) {
            loginText.error = "Enter you login!"
            return false
        }

        if (passwordText.text.toString() != password) {
            passwordText.error = "Enter you password!"
            return false
        }

        return true
    }

    private fun registerOrLoginPerson() {

        loginBtn.setOnClickListener {
            inputCheck()
        }

        registerBtn.setOnClickListener {
            inputCheck()
        }

    }

    private fun inputCheck(){
        if (checkErrorsInLoginAndPasswordEditText()) {
            Toast.makeText(this, "You do it!!", Toast.LENGTH_SHORT).show()
        }
    }
}