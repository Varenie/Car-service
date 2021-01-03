package com.varenie.carservice.Activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.rengwuxian.materialedittext.MaterialEditText
import com.varenie.carservice.R


class EntranceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        val btnAuth = findViewById<Button>(R.id.btn_auth)
        val btnReg = findViewById<Button>(R.id.btn_reg)

        //назначение обработчиков нажатий
        btnAuth.setOnClickListener {
            authListener(it)
        }

        btnReg.setOnClickListener {
            regListener(it)
        }
    }

    //окно авторизации, проверки добавятся позже
    fun authListener(view: View) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Авторизация")

        val inflater = LayoutInflater.from(this)
        val authWindow = inflater.inflate(R.layout.auth_layout, null)
        dialog.setView(authWindow)

        val login = findViewById<MaterialEditText>(R.id.met_login)
        val password = findViewById<MaterialEditText>(R.id.met_pass)

        dialog.setNegativeButton("Отменить", DialogInterface.OnClickListener { dialogInterface, which ->
            dialogInterface.dismiss()
        })

        // при нажатии на кнопку подтвердить просиходят проверки введненных данных
        // если все ок, то переходим на основное активити
        // пока прочто переходим на следующее активити
        dialog.setPositiveButton("Подтвердить", DialogInterface.OnClickListener { dialogInterface, which ->
            startActivity(Intent(this, NavigationActivity::class.java))
        })

        dialog.show()
    }

    //окно регистрации, проверки добавятся позже
    fun regListener(view: View) {
        val dialog  = AlertDialog.Builder(this)
        dialog.setTitle("Регистрация")

        val inflater = LayoutInflater.from(this)
        val regWindow = inflater.inflate(R.layout.reg_layout, null)
        dialog.setView(regWindow)

        dialog.setNegativeButton("Отменить", DialogInterface.OnClickListener { dialogInterface, which ->
            dialogInterface.dismiss()
        })

        //при нажатии происходит проверка введенных данных
        //при корректности данных создается акк, и пользователя перебрасывает в активти навигации
        //прверки будут реализованы позже, пока просто переход в активити
        dialog.setPositiveButton("Подтвердить", DialogInterface.OnClickListener { dialogInterface, which ->
            startActivity(Intent(this, NavigationActivity::class.java))
        })

        dialog.show()
    }
}