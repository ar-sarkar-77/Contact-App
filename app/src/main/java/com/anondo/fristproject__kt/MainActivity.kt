package com.anondo.fristproject__kt

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.database.Cursor
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var imageAdd: ImageView
    lateinit var edSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        imageAdd = findViewById(R.id.imageAdd)
        edSearch = findViewById(R.id.edSearch)

        var db = DataBaseOpenHelper(this)

        updateUI(db.showData())


        imageAdd.setOnClickListener{
            startActivity(Intent(this , MainActivity2::class.java))
        }

        edSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                var key : String = edSearch.text.toString()
                updateUI(db.searchData(key))

            }

            override fun afterTextChanged(p0: Editable?) {

            }


        })


    }

    fun updateUI (cursor: Cursor){

        listView.adapter = null

       val db = DataBaseOpenHelper(this)

      //  var cursor : Cursor = db.showData()

        if (cursor!=null && cursor.count>0) {

            val data = ArrayList<hashMap>()

            while (cursor.moveToNext()) {

                var id: Int = cursor.getInt(0)
                var name: String = cursor.getString(1)
                var number: Int = cursor.getInt(2)

                data.add(hashMap("" + id, "" + name, "" + number))

            }

            val adapter = CustomAdapter(this , data)
            listView.adapter=adapter

        }
        else{
          //  Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show()
        }

    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!Custom Adapter!!!!!!!!!!!!!!!!!!!!!!!!

    class CustomAdapter(private val context: Context, private val arraydata : ArrayList<hashMap>):BaseAdapter(){
        override fun getCount(): Int {
            return arraydata.size
        }

        override fun getItem(position: Int): Any {
            return arraydata.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {
            val view: View = p1?: LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
            var title : TextView=view.findViewById(R.id.titleText)
            var number : TextView=view.findViewById(R.id.subtitleText)
            var con_lay : LinearLayout=view.findViewById(R.id.contact_layout)

            var sharedPreferences : SharedPreferences = context.getSharedPreferences("MyPrefs", MODE_PRIVATE)
            var editor : Editor = sharedPreferences.edit()

            var dataCon = arraydata.get(position)

            var namee : String = dataCon.name
            var numberr : String = dataCon.mobile

            title.text = namee
            number.text = "0"+numberr

            con_lay.setOnClickListener{
                editor.putString("id", dataCon.id )
                editor.putString("name", dataCon.name)
                editor.putString("number", "0"+dataCon.mobile)

                editor.apply()

                val intent = Intent(context, MainActivity3::class.java)
             //   intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK // কারণ context হচ্ছে non-activity context
                context.startActivity(intent)


            }

            return view
        }

    }

    override fun onPostResume() {
        super.onPostResume()
        updateUI(DataBaseOpenHelper( this).showData())
    }

}