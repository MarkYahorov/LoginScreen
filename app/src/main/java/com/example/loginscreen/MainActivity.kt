package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text
import android.text.TextWatcher as TextWatcher

class MainActivity : AppCompatActivity() {

    private lateinit var loginText: EditText
    private lateinit var passwordText: EditText
    private lateinit var registerBtn: Button
    private lateinit var loginBtn: Button

    /*private val login = "admin"
      private val password = "password"*/

    private val login = Login("admin")
    private val password = Password("password")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        find()
        check()
        registerOrLoginPerson()
    }

    private fun find() {
        loginText = findViewById(R.id.login)
        passwordText = findViewById(R.id.password)
        registerBtn = findViewById(R.id.regBtn)
        loginBtn = findViewById(R.id.logBtn)
    }

    //проверка полей на соответствие
    private fun checkErrorsInLoginAndPasswordEditText(): Boolean {

        /*if (TextUtils.isEmpty(loginText.text)) {
            loginText.error = "Enter you login!"
            return false
        }

        if (!TextUtils.equals(loginText.text, login.login)) {
            loginText.error = "Enter you login!"
            return false
        }

        if (TextUtils.isEmpty(passwordText.text)) {
            passwordText.error = "Enter you password!"
            return false
        }

        if (!TextUtils.equals(passwordText.text, password.password)) {
            passwordText.error = "Enter you password!"
            return false
        }*/

        if (loginText.text.toString() != login.login) {
            loginText.error = "Enter you login!"
            return false
        }

        if (passwordText.text.toString() != password.password) {
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

    //вывод тоста
    private fun inputCheck() {
        if (checkErrorsInLoginAndPasswordEditText()) {
            Toast.makeText(this, "You do it!!", Toast.LENGTH_SHORT).show()
        }
    }

    //изменение текста и включение кнопки для нажатия
    private fun check() {
        loginText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                registerBtn.isEnabled = true
                loginBtn.isEnabled = true
                if (TextUtils.isEmpty(loginText.text) || TextUtils.isEmpty(passwordText.text)) {
                    loginBtn.isEnabled = false
                    registerBtn.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        passwordText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                registerBtn.isEnabled = true
                loginBtn.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
}