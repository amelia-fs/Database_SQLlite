package com.example.sqllite_amel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)
        val editusername: EditText = findViewById(R.id.editusername)
        val editpwd: EditText = findViewById(R.id.editpassword)
        val btnlogin: Button = findViewById(R.id.btnlogin)
        btnlogin.setOnClickListener {
            if (editusername.text.toString()=="admin"){
                if(editpwd.text.toString()=="12345"){
                    val pindah = Intent(this, MainActivity::class.java)
                    startActivity(pindah)
                }else {
                    val error: Toast = Toast.makeText(applicationContext, " Password salah!", Toast.LENGTH_SHORT)
                    error.show()
                }
            }else {
                val error: Toast = Toast.makeText(applicationContext, " Username salah!", Toast.LENGTH_SHORT)
                error.show()
            }
        }
    }
}
