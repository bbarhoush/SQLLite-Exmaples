package com.example.sqliteexample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Store(con:Context): SQLiteOpenHelper(con, "store.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table store(id integer, name text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}