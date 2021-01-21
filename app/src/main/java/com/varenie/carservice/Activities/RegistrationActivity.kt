package com.varenie.carservice.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.rengwuxian.materialedittext.MaterialEditText
import com.varenie.carservice.R

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val btnReg = findViewById<Button>(R.id.btn_reg)

        btnReg.setOnClickListener {
            registratioListener()
        }
    }

//  Сначала вызывает функцию проверки ввода, после еек прохождения прееходит в основное активити
    private fun registratioListener() {
        val fio = findViewById<TextInputLayout>(R.id.til_fio_reg)
        val email = findViewById<TextInputLayout>(R.id.til_email_reg)
        val phone = findViewById<TextInputLayout>(R.id.til_phone_reg)
        val pass = findViewById<TextInputLayout>(R.id.til_pass_reg)
        val confirmPass = findViewById<TextInputLayout>(R.id.til_confirm_pass_reg)

//      очищает сообщения об ошибках, после ввода текста
        fio.editText?.doAfterTextChanged {
            fio.error = null
        }

        email.editText?.doAfterTextChanged {
            email.error = null
        }

        phone.editText?.doAfterTextChanged {
            phone.error = null
        }

        pass.editText?.doAfterTextChanged {
            pass.error = null
        }

        confirmPass.editText?.doAfterTextChanged {
            confirmPass.error = null
        }

        if (checkReg(fio, email, phone, pass, confirmPass)) {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }

//  Функция для проверки вводимых данных пользователя
//  Проверки еще не закончены
    private fun checkReg(fio: TextInputLayout?, email: TextInputLayout?, phone: TextInputLayout?, password: TextInputLayout?, confirmPass: TextInputLayout?): Boolean {
        var isValid = true

        if (email?.editText?.text.isNullOrBlank()) {
            email?.error = "Введите email!"
            isValid = false
        }

        if (fio?.editText?.text.isNullOrBlank()) {
            fio?.error = "Введите ФИО!"
            isValid = false
        }

        if (phone?.editText?.text.isNullOrBlank()) {
            phone?.error = "Введите телефон!"
            isValid = false
        }

        if (password?.editText?.text.isNullOrBlank()) {
            password?.error = "Введите пароль!"
            isValid = false
        }

        if (isValid) {
            val pass = password?.editText?.text.toString()
            val passConfirm = confirmPass?.editText?.text.toString()

            when {
                pass.length < 6 -> {
                    password?.error = "Пароль должен содеражть от 6 до 15 символов"
                    isValid = false
                }

                pass.compareTo(passConfirm) != 0 -> {
                    password?.error = "Пароли должны совпадать!"
                    confirmPass?.error = "Пароли должны совпадать!"
                    isValid = false
                }
            }
        }

        return isValid
    }
}
