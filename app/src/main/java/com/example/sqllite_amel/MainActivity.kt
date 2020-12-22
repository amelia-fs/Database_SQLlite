package com.example.sqllite_amel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputEmail: EditText
    lateinit var inputNama: EditText
    lateinit var inputAlamat: EditText
    lateinit var inputJk: EditText
    lateinit var inputTelepon: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputEmail = findViewById(R.id.input_email)
        inputNama = findViewById(R.id.input_nama)
        inputAlamat = findViewById(R.id.inpu_alamat)
        inputJk = findViewById(R.id.input_jk)
        inputTelepon = findViewById(R.id.input_telepon)
        userDBHelper = DBHelper(this)
    }
    fun addData(v: View){
        var emailin = inputEmail.text.toString()
        var namain = inputNama.text.toString()
        var alamatin = inputAlamat.text.toString()
        var jkin = inputJk.text.toString()
        var teleponin = inputTelepon.text.toString()
        userDBHelper.insertData(emailin, namain, alamatin, jkin, teleponin)
        inputEmail.setText("")
        inputNama.setText("")
        inputAlamat.setText("")
        inputJk.setText("")
        inputTelepon.setText("")
    }
    fun showAll(v: View){
        var pindah = Intent(this, MainActivity2::class.java)
        startActivity(pindah)
    }
}