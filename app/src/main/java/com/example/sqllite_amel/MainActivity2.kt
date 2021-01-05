package com.example.sqllite_amel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper
    lateinit var tampil: TextView
    lateinit var  ltampil: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        userDBHelper = DBHelper(this)
        tampil = findViewById(R.id.tampil_semua)
        ltampil = findViewById(R.id.ltampil)
        var tampilkan = userDBHelper.fullData()
 //      ltampil.removeAllViews()
        tampilkan.forEach {
            tampil.text = tampil.text.toString() + " " + it.email.toString() + " - " + it.nama.toString() + " - " + it.alamat.toString() + " - " +
                    it.jk.toString() + " - " + it.telepon.toString() + "\n"
   //         ltampil.addView(tampil)
        }
    }
}