package com.example.lab05_userlogin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_shoping_.*

class Shopping_Activity : AppCompatActivity() {
    lateinit var currentUser: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoping_)

        val intent = intent
        var temp = intent.getSerializableExtra("User")
        currentUser = temp as User
        tvLoginHistory.text = "Hello Wellcome " + currentUser.userName
    }




}