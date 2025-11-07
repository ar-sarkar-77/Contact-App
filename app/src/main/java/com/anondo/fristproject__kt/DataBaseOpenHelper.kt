package com.anondo.fristproject__kt

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseOpenHelper(context: Context?, ) : SQLiteOpenHelper(context, "contact_Kt", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table contact (id INTEGER primary key autoincrement, name TEXT,number TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table if exists contact")
    }
    
    fun getContact(name:String,number:String) {
        var database : SQLiteDatabase = this.writableDatabase

        var conval = ContentValues()
        conval.put("name",name)
        conval.put("number",number)

        database.insert("contact" , null , conval)
    }

    fun showData(): Cursor {

        var db : SQLiteDatabase = this.readableDatabase

        var cursor : Cursor = db.rawQuery("select * from contact", null)

        return cursor
    }


    fun deleteData(id: String?) {

        var db : SQLiteDatabase = this.writableDatabase
        db.delete("contact", "id = ?", arrayOf(id))
    }

    fun searchData(key: String?): Cursor {
        val db: SQLiteDatabase = this.readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT * FROM contact WHERE name LIKE ?",
            arrayOf("%$key%")
        )
        return cursor
    }

    fun updateData(name: String?, number: String? , id: String?): Int {

        val  db : SQLiteDatabase =this.writableDatabase

        val conval = ContentValues()

        conval.put("name", name)
        conval.put("number", number)

        return db.update("contact", conval , "id = ?" , arrayOf(id.toString()))
    }

}