package com.varenie.carservice.Activities

import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.rengwuxian.materialedittext.MaterialEditText
import com.varenie.carservice.R
import java.util.*


class EntranceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        val btnAuth = findViewById<Button>(R.id.btn_auth)
        val tvReg = findViewById<TextView>(R.id.tv_reg)

        //назначение обработчиков нажатий
        btnAuth.setOnClickListener {
            authListener()
        }

        tvReg.setOnClickListener {
            regListener(it)
        }
    }


//  вызывает функцию проверки ввода, если ее проходит, то прееходит в основное активити
    fun authListener() {
        val email = findViewById<TextInputLayout>(R.id.til_email_auth)
        val password = findViewById<TextInputLayout>(R.id.til_pass_auth)

//      очищает сообщения об ошибках, после ввода текста
        email.editText?.doAfterTextChanged {
            email.error = null
        }

        password.editText?.doAfterTextChanged {
            password.error = null
        }

        if (checkAuth(email, password)) {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }

//  Проверка данных пользователя
    private fun checkAuth(email: TextInputLayout?, password: TextInputLayout?): Boolean {
        var isValid = true

        if (email?.editText?.text.isNullOrBlank()) {
            email?.error = "Введите логин"
            isValid = false
        }

        if (password?.editText?.text.isNullOrBlank()) {
                password?.error = "Введите пароль"
                isValid = false
        }

        return isValid
    }

//  Переход на регистраци.
    fun regListener(view: View) {
        startActivity(Intent(this, RegistrationActivity::class.java))
    }
}