package com.example.sqliteexample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class School(con:Context): SQLiteOpenHelper(con, "school.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table student(id integer primary key, name text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}