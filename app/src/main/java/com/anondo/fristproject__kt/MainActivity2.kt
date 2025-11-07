package com.anondo.fristproject__kt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var btn : Button = findViewById(R.id.btn)
        var edtNam : EditText = findViewById(R.id.edtNam)
        var edtNum : EditText = findViewById(R.id.edtNum)

        btn.setOnClickListener{

            val dba = DataBaseOpenHelper(this)

            var name : String = (edtNam.text.toString())
            var num : String = edtNum.text.toString()

            var number :String = num

            dba.getContact(name, number)

            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}