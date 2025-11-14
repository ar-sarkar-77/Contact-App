package com.anondo.fristproject__kt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var btn : Button = findViewById(R.id.btn)
        var edtNam : EditText = findViewById(R.id.edtNam)
        var edtNum : EditText = findViewById(R.id.edtNum)

        val db = DataBaseOpenHelper(this)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)



        val id = intent.getStringExtra("idss")
        val name = intent.getStringExtra("namess")
        val numberr = intent.getStringExtra("numberss")

        edtNam.setText(name)
        if (numberr!!.startsWith("0")) {
            edtNum.setText(numberr!!.substring(1))
        } else {
            edtNum.setText(numberr)
        }

        btn.setOnClickListener{

            var name : String = edtNam.text.toString()
            var number : String = edtNum.text.toString()

            db.updateData(name,number,id)

            val editor = sharedPreferences.edit()

            editor.clear()
            editor.apply()

            finish()

            onBackPressed()

        }




    }
}