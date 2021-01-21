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
            authListener(it)
        }

        tvReg.setOnClickListener {
            regListener(it)
        }
    }


    //создает диалоговое окно Авторизации, пока только первичные проверки ввода
    fun authListener(view: View) {
        val login = findViewById<TextInputLayout>(R.id.til_login_auth)
        val password = findViewById<TextInputLayout>(R.id.til_pass_auth)

       login.editText?.doAfterTextChanged {
            login.error = null
        }

        password.editText?.doAfterTextChanged {
            password.error = null
        }

        if (checkAuth(login, password)) {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }

    private fun checkAuth(login: TextInputLayout?, password: TextInputLayout?): Boolean {
        var isValid = true

        if (login?.editText?.text.isNullOrBlank()) {
            login?.error = "Введите логин"
            isValid = false
        }

        if (password?.editText?.text.isNullOrBlank()) {
                password?.error = "Введите пароль"
                isValid = false
        }

        return isValid
    }

    //создает диалоговое окно Регистрации, пока только первичные проверки ввода
    fun regListener(view: View) {
        startActivity(Intent(this, RegistrationActivity::class.java))
    }

//  Впринципе можно сделать так, что он сначала проверяет все поля, а потом выводит сообщение, какие поля не соответствуют
    private fun checkReg(emailMet: MaterialEditText?, loginMet: MaterialEditText?, fioMet: MaterialEditText?, phoneMet: MaterialEditText?, passwordMet: MaterialEditText?, confirmPassMet: MaterialEditText?): Boolean {
        when {
            emailMet?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Введите email!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false
            }

            loginMet?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Введите логин!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false
            }

            fioMet?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Введите ФИО!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false
            }

            phoneMet?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Введите телефон!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false
            }

            passwordMet?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Введите пароль!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false

            }

            else -> {
                val pass = passwordMet?.text.toString()
                val passConfirm = confirmPassMet?.text.toString()

                when {
                    pass.length < 5  || pass.length > 15-> {
                        val toast = Toast.makeText(
                                this,
                                "Пароль должен содеражть от 5 до 15 символов",
                                Toast.LENGTH_SHORT
                        )
                        toast.setGravity(Gravity.TOP, 0, 0)
                        toast.show()
                        return false
                    }

                    pass.compareTo(passConfirm) != 0 -> {
                        val toast = Toast.makeText(
                                this,
                                "Пароли должны совпадать!",
                                Toast.LENGTH_SHORT
                        )
                        toast.setGravity(Gravity.TOP, 0, 0)
                        toast.show()
                        return false
                    }
                }

                return true
            }
        }
    }

}