package com.example.quizapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmit(view: View) {
        var result:Int=0
        var Q1yes=findViewById<RadioButton>(R.id.rbQuestion1Yes)
        var Question2Answer1=findViewById<CheckBox>( R.id.Q2answer1)
        var Question2Answer2=findViewById<CheckBox>(R.id.Q2answer2)
        var Question2Answer3= findViewById<CheckBox>( R.id.Q2answer3)
        var Question2Answer4= findViewById<CheckBox>( R.id.Q2answer4)

        val dateTime = LocalDateTime.now()
        val currentDateTime =dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy H:m:ss"))
        if(Q1yes.isChecked){
            result+=50
        }
        if(Question2Answer3.isChecked){
            if (!Question2Answer1.isChecked && !Question2Answer2.isChecked && !Question2Answer4.isChecked)
                result+=50
        }

        val builder= AlertDialog.Builder(this)
        builder.setTitle("Your result is:")
        builder.setMessage(" You submitted on $currentDateTime, You Scored $result%")
        builder.setPositiveButton("Ok"){dialog, which ->
            dialog.dismiss()
        }
        var dialog: AlertDialog =builder.create()
        dialog.show()
    }
    fun onReset(view: View) {
        rgQuestion1.clearCheck()
        Q2answer1.isChecked=false
        Q2answer2.isChecked=false
        Q2answer3.isChecked=false
        Q2answer4.isChecked=false
    }
}


