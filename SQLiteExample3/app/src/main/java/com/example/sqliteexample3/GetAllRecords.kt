package com.example.sqliteexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_get_all_records.*

class GetAllRecords : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_all_records)

        var s = School(this)
        var db = s.readableDatabase
        var result:String = ""

        var cur = db.rawQuery("select * from student", null)
        if(cur.count == 0)
            Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show()
        else
        {
            cur.moveToFirst()

            while (!cur.isAfterLast)
            {
                result+= "ID: " + cur.getString(cur.getColumnIndex("id")) + "\n" +
                    "Name: " + cur.getString(cur.getColumnIndex("name")) +  "\n" +
                        "Mark: " +  cur.getString(cur.getColumnIndex("mark")) + "\n****************************************\n\n"
                cur.moveToNext()
            }

            tv.text = result
        }
    }
}
