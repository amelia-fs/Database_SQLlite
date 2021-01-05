package com.example.sqllite_amel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.os.bundleOf

class UpdateActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var inputEmail: EditText
    lateinit var inputNama: EditText
    lateinit var inputAlamat: EditText
    lateinit var inputJk: EditText
    lateinit var inputTelepon: EditText
    lateinit var emailg: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        inputEmail = findViewById(R.id.input_emailu)
        inputNama = findViewById(R.id.input_namau)
        inputAlamat = findViewById(R.id.inpu_alamatu)
        inputJk = findViewById(R.id.input_jku)
        inputTelepon = findViewById(R.id.input_teleponu)
        userDBHelper = DBHelper(this)
        val bundle =  intent.extras
        if (bundle != null){
            emailg = bundle.getString("emailk").toString()
            inputEmail.setText(bundle.getString("emailk"))
            inputNama.setText(bundle.getString("namak"))
            inputAlamat.setText(bundle.getString("alamatk"))
            inputJk.setText(bundle.getString("jkk"))
            inputTelepon.setText(bundle.getString("teleponk"))
        }
        userDBHelper = DBHelper(this)
    }
    fun cancelData(v: View){
        val kembali = Intent(this, RvDbActivity::class.java)
        startActivity(kembali)
    }
    fun updateData(v: View){
        var namai = inputNama.text.toString()
        var alamatin = inputAlamat.text.toString()
        var jkin = inputJk.text.toString()
        var teleponin = inputTelepon.text.toString()
        var emailin = emailg
        userDBHelper.updateData(emailin, namai, alamatin, jkin, teleponin)
        val kembali = Intent(this, RvDbActivity::class.java)
        startActivity(kembali)
    }
}