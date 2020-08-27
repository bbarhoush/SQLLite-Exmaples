package com.example.sqliteexample

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        //supportActionBar?.hide() // hide the title bar
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)         //enable full screen
        setContentView(R.layout.activity_main)

        save.setOnClickListener {

            var s = School(this@MainActivity)
            var db = s.writableDatabase

            db.execSQL("insert into student values (?,?)",
                arrayOf(id.text.toString(), name.text.toString()))
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
        }

        button2.setOnClickListener {

/*          var s1 = Store(this)
            var db = s1.writableDatabase

            db.execSQL("insert into store values(?,?)", arrayOf(id.text.toString(), name.text.toString()))
            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show()*/

            var s = School(this)
            var db = s.readableDatabase

            var c = db.rawQuery("select * from student where id = ?", arrayOf(id.text.toString()))
            if(c.count == 0)
                Toast.makeText(this, "Not found", Toast.LENGTH_LONG).show()
            else
            {
                c.moveToFirst()
                while (!c.isAfterLast)
                {
                    Toast.makeText(this, c.getString(1), Toast.LENGTH_LONG).show()
                    c.moveToNext()
                }
            }
        }
    }
}
