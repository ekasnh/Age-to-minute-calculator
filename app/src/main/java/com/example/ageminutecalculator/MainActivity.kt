package com.example.ageminutecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.buttonDatePicker)
        button.setOnClickListener {view->
            clickdatepicker(view)
            Toast.makeText(this, "Worked", Toast.LENGTH_SHORT).show()


        }

    }
    fun clickdatepicker(view:View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener
        { Seview, Seyear, Semonth, SedayOfMonth ->
            Toast.makeText(this,"date is $Seyear + $Semonth + $SedayOfMonth",Toast.LENGTH_SHORT).show()
            val selecteddate= "$SedayOfMonth/${Semonth+1}/$Seyear"
            val selectedtext = findViewById<TextView>(R.id.toselectdate)
            selectedtext.setText(selecteddate)
            //to show format
            val sdf = SimpleDateFormat("DD/MM/YYYY", Locale.ENGLISH)
            val theDate = sdf.parse(selecteddate)


            val selectedDateinMinutes = theDate!!.time/60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateMinutes = currentDate!!.time/60000
            val differenceinminutes= currentDateMinutes-selectedDateinMinutes
            val displaymyminutes = findViewById<TextView>(R.id.todisplayageinminutes)
            displaymyminutes.setText(differenceinminutes.toString())
        },year,month,day).show()

    }

}