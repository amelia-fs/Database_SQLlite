package com.example.sqllite_amel

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        val DATABASE_NAME = "Users.db"
        val DATABASE_VERSION = 1
        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBinfo.UserMasuk.TABLE_NAME + " (" + DBinfo.UserMasuk.COL_EMAIL +
                    " VARCHAR(200) PRIMARY KEY, " + DBinfo.UserMasuk.COL_NAMA + " TEXT, " +
                    DBinfo.UserMasuk.COL_ALAMAT + " TEXT , " + DBinfo.UserMasuk.COL_JK + " TEXT, " +
                    DBinfo.UserMasuk.COL_TELEPON + " TEXT)"
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + DBinfo.UserMasuk.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL(SQL_CREATE_ENTRIES)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertData(emailin: String, namain: String, alamatin: String, jkin: String, teleponin: String): Boolean{
        val db = writableDatabase
        val namatabelt = DBinfo.UserMasuk.TABLE_NAME
        val emailt = DBinfo.UserMasuk.COL_EMAIL
        val namat = DBinfo.UserMasuk.COL_NAMA
        val alamatt = DBinfo.UserMasuk.COL_ALAMAT
        val jkt = DBinfo.UserMasuk.COL_JK
        val telepont = DBinfo.UserMasuk.COL_TELEPON
        var sql = "INSERT INTO "+ namatabelt +"("+emailt+", "+namat+", "+alamatt+", "+jkt+", "+telepont+") " +
                "VALUES('"+emailin+"', '"+namain+"', '"+alamatin+"', '"+jkin+"', '"+teleponin+"')"
        db.execSQL(sql)
        return true
    }
    fun fullData():ArrayList<DBModel>{
  //      val user = ArrayList<DBModel>()
        val user = arrayListOf<DBModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM "+ DBinfo.UserMasuk.TABLE_NAME, null)
        }catch (e:SQLException){
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var emailt: String
        var namat: String
        var alamatt: String
        var jkt: String
        var telepont: String
        if (cursor!!.moveToFirst()){
            while (cursor.isAfterLast==false){
                emailt = cursor.getString(cursor.getColumnIndex(DBinfo.UserMasuk.COL_EMAIL))
                namat = cursor.getString(cursor.getColumnIndex(DBinfo.UserMasuk.COL_NAMA))
                alamatt = cursor.getString(cursor.getColumnIndex(DBinfo.UserMasuk.COL_ALAMAT))
                jkt = cursor.getString(cursor.getColumnIndex(DBinfo.UserMasuk.COL_JK))
                telepont = cursor.getString(cursor.getColumnIndex(DBinfo.UserMasuk.COL_TELEPON))

                user.add(DBModel(emailt, namat, alamatt, jkt, telepont))
                cursor.moveToNext()
            }
        }
        return user
    }
    fun deleteData(emailin: String){
        val db = writableDatabase
        val namatablet = DBinfo.UserMasuk.TABLE_NAME
        val emailt = DBinfo.UserMasuk.COL_EMAIL
        val sql = "DELETE FROM " +namatablet+ " WHERE " +emailt+"='"+emailin+"'"
        db.execSQL(sql)
    }
    fun updateData(emailin: String, namain: String, alamatin: String, jkin: String, teleponin: String){
        val db = writableDatabase
        val namatablet = DBinfo.UserMasuk.TABLE_NAME
        val emailt = DBinfo.UserMasuk.COL_EMAIL
        val namat = DBinfo.UserMasuk.COL_NAMA
        val alamatt = DBinfo.UserMasuk.COL_ALAMAT
        val jkt = DBinfo.UserMasuk.COL_JK
        val telepont = DBinfo.UserMasuk.COL_TELEPON
        var sql = "UPDATE "+ namatablet + " SET "+
                namat+"='"+namain+"', "+alamatt+"='"+alamatin+"', "+jkt+"='"+jkin+"', "+telepont+"='"+teleponin+"' "+
                "WHERE "+emailt+"='"+emailin+"'"
        db.execSQL(sql)
    }

}