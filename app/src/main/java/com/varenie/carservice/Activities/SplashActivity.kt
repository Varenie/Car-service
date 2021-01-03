package com.varenie.carservice.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varenie.carservice.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()

        // здесб потом будет проверка на авторизацию юзера
        Thread(Runnable {
            Thread.sleep(2000) //загрузка будет идти 2 секунды
            startActivity(Intent(this, EntranceActivity::class.java))
            finish()
        }).start()
    }
}