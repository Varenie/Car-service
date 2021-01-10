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
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.rengwuxian.materialedittext.MaterialEditText
import com.varenie.carservice.R
import java.util.*


class EntranceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        val btnAuth = findViewById<Button>(R.id.btn_auth)
        val btnReg = findViewById<Button>(R.id.btn_reg)

        //назначение обработчиков нажатий
        btnAuth.setOnClickListener {
            authListener(it, "", "")
        }

        btnReg.setOnClickListener {
            regListener(it, "", "", "", "", "", "")
        }
    }


    //создает диалоговое окно Авторизации, пока только первичные проверки ввода
    fun authListener(view: View, login: String?, password: String?) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Авторизация")

        val inflater = LayoutInflater.from(this)
        val authWindow = inflater.inflate(R.layout.auth_layout, null)
        dialog.setView(authWindow)

        val loginMet = authWindow.findViewById<MaterialEditText>(R.id.met_login_auth)
        val passwordMet = authWindow.findViewById<MaterialEditText>(R.id.met_pass_auth)

//      Назначаем текст с прошлого окна
        loginMet.setText(login)
        passwordMet.setText(password)

//      диалог закрывается при нажатии на кнопку отменить
        dialog.setNegativeButton("Отменить") { dialogInterface, which ->
            dialogInterface.dismiss()
        }

        dialog.setPositiveButton("Подтвердить") { dialogInterface, which ->

//          Вызвается функция проверки ввода данных, если все ок, запукскается следующее активити
            if (checkAuth(loginMet, passwordMet)) {
                startActivity(Intent(this, NavigationActivity::class.java))
            } else {
//              если возвращено false, диалог перезапускается, передавая заполненные поля
                authListener(view, loginMet.text.toString(), passwordMet.text.toString())
            }
        }

        dialog.show()
    }

    private fun checkAuth(login: MaterialEditText?, password: MaterialEditText?): Boolean {

        when {
            login?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Заполните поле логина!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false
            }

            password?.text.isNullOrBlank() -> {
                val toast = Toast.makeText(
                        this,
                        "Введите пароль!",
                        Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                return false
            }
        }

        return true
    }

    //создает диалоговое окно Регистрации, пока только первичные проверки ввода
    fun regListener(view: View, email: String?, login: String?, fio: String?, phone: String?, pass: String?, passConfirm: String?) {
        val dialog  = AlertDialog.Builder(this)
        dialog.setTitle("Регистрация")

        val inflater = LayoutInflater.from(this)
        val regWindow = inflater.inflate(R.layout.reg_layout, null)
        dialog.setView(regWindow)

        val emailMet = regWindow.findViewById<MaterialEditText>(R.id.met_email)
        val loginMet = regWindow.findViewById<MaterialEditText>(R.id.met_login)
        val fioMet = regWindow.findViewById<MaterialEditText>(R.id.met_FIO)
        val phoneMet = regWindow.findViewById<MaterialEditText>(R.id.met_phone)
        val passwordMet = regWindow.findViewById<MaterialEditText>(R.id.met_pass)
        val confirmPassMet = regWindow.findViewById<MaterialEditText>(R.id.met_pass_confirm)

//      Добавление инфы с прошлого окна
        emailMet.setText(email)
        loginMet.setText(login)
        fioMet.setText(fio)
        phoneMet.setText(phone)
        passwordMet.setText(pass)
        confirmPassMet.setText(passConfirm)

        dialog.setNegativeButton("Отменить") { dialogInterface, which ->
            dialogInterface.dismiss()
        }


        dialog.setPositiveButton("Подтвердить") { dialogInterface, which ->
//          запускается проверка всех полей, если все ок, переходим на следующее активити
            if (checkReg(emailMet, loginMet, fioMet, phoneMet, passwordMet, confirmPassMet)) {
                startActivity(Intent(this, NavigationActivity::class.java))
            } else {


//              Сделлал, чтобы строка не сильно длинная была, тут занчения с editText берутся
                val emailNew = emailMet.text.toString()
                val loginNew = loginMet.text.toString()
                val fioNew = fioMet.text.toString()
                val phoneNew = phoneMet.text.toString()
                val passNew = passwordMet.text.toString()
                val passConfirmNew = confirmPassMet.text.toString()

//              Если все плохо, то перезапускаем окно
                regListener(view, emailNew, loginNew, fioNew, phoneNew, passNew, passConfirmNew)
            }
        }

        dialog.show()
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