package com.example.lab06_soln2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register_.*

class Register_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_)
    }

    fun OnCreateNewAccount(view: View) {
        val data = Intent()
        val user = User(etFirstName.text.toString(),etLastName.text.toString(),etEmail.text.toString(),etPassword.text.toString())
        //---set the data to pass back
        data.putExtra("user", user)
        setResult(Activity.RESULT_OK, data)
        //---close the activity---
        finish()
    }
}
