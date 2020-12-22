package com.example.sqllite_amel

import android.provider.BaseColumns

object DBinfo {
    class UserMasuk: BaseColumns{
        companion object{
            val TABLE_NAME = "users"
            val COL_EMAIL = "email"
            val COL_NAMA = "nama"
            val COL_ALAMAT = "alamat"
            val COL_JK = "jk"
            val COL_TELEPON = "telepon"
        }
    }
}