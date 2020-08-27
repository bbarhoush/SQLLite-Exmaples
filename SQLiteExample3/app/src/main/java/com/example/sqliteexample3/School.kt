package com.example.sqliteexample3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class School(con:Context) : SQLiteOpenHelper(con, "school.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("create table student(id integer primary key, name varchar(15), mark float)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}