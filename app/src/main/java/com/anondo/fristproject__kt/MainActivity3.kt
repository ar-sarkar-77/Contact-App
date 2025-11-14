package com.anondo.fristproject__kt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    lateinit var names : TextView
    lateinit var numbers : TextView
    lateinit var delete_Ig : ImageView
    lateinit var edit_Ig : ImageView
    lateinit var call : ImageView
    lateinit var message : ImageView
    lateinit var email : ImageView
    lateinit var whatsapp : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        names = findViewById(R.id.name)
        numbers = findViewById(R.id.number)
        delete_Ig = findViewById(R.id.delete_Ig)
        edit_Ig = findViewById(R.id.edit)
        call = findViewById(R.id.call)
        message = findViewById(R.id.message)
        email = findViewById(R.id.email)
        whatsapp = findViewById(R.id.whatsapp)

        val db = DataBaseOpenHelper(this)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val id = sharedPreferences.getString("id","defaultId")
        val name = sharedPreferences.getString("name", "")
        val number = sharedPreferences.getString("number", "")

        names.text = name
        numbers.text = number.toString()

        delete_Ig.setOnClickListener{

            db.deleteData(id.toString())

            val editor = sharedPreferences.edit()

            editor.clear()
            editor.apply()

            finish()

        }

        edit_Ig.setOnClickListener{

            var editintent = Intent(this,MainActivity4::class.java)
            editintent.putExtra("namess" , name)
            editintent.putExtra("numberss" , number)
            editintent.putExtra("idss" , id)
            startActivity(editintent)

        }

        call.setOnClickListener{

            var dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data= Uri.parse("tel:"+number)
            startActivity(dialIntent)

        }

        message.setOnClickListener{

            val messageIntent = Intent(Intent.ACTION_VIEW)
            messageIntent.data= Uri.parse("sms:"+number)
            startActivity(messageIntent)

        }

        whatsapp.setOnClickListener{

            val url = "https://wa.me/"+number

            val whatsappIntent  = Intent(Intent.ACTION_VIEW)
            whatsappIntent.data= Uri.parse(url)
            intent.setPackage("com.whatsapp")
            startActivity(whatsappIntent)

        }

        email.setOnClickListener{

            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:example@email.com")
            startActivity(emailIntent)

        }


    }
        override fun onPause() {
            super.onPause()
            onBackPressed()
        }

}