package com.example.sqliteexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var s = School(this)
        var db = s.writableDatabase

        btn2.setOnClickListener {

            try {

                db.execSQL("insert into student values(?,?,?)",
                    arrayOf(et1.text.toString(), et2.text.toString(), et3.text.toString()))
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            }
            catch (e:Exception)
            {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

        btn1.setOnClickListener {

            db.execSQL("update student set name = ?, mark=? where id=?", arrayOf(et2.text.toString(),
                et3.text.toString(), et1.text.toString()))
            Toast.makeText(this, "Data updated", Toast.LENGTH_LONG).show()
        }

        btn3.setOnClickListener {

            var cur = db.rawQuery("select * from student where id=?", arrayOf(et1.text.toString()))

            if(cur.count == 0)
            {
                Toast.makeText(this, "no data found", Toast.LENGTH_LONG).show()
                et1.setText("")
                et2.setText("")
                et3.setText("")
            }

            else
            {
                cur.moveToFirst()
                //method number one
                et2.setText(cur.getString(1))
                et3.setText(cur.getString(2))

                //another method
                et2.setText(cur.getString(cur.getColumnIndex("name")))
                et3.setText(cur.getString(cur.getColumnIndex("mark")))
            }
        }
    }
}
