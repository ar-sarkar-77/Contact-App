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

            var name : String = (edtNam.text.toString()).trim()
            var number : String = edtNum.text.toString().trim()

            if (number.isEmpty()) {
                edtNum.error = "Number cannot be empty"
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                edtNum.error = "Number cannot be empty"
                return@setOnClickListener
            }

            if (number.startsWith("0")) {
                edtNum.error = "Number cannot start with 0"
                return@setOnClickListener
            }

            dba.getContact(name, number)

            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}