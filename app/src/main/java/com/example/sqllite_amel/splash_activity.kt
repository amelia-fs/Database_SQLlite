package com.example.sqllite_amel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activity)
        Handler().postDelayed({
            val pindah = Intent(this,login_activity::class.java)
            startActivity(pindah)
            finish()
        },3000)
    }

}