package com.example.lab06_soln2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_shopping_.*

class Shopping_Activity : AppCompatActivity() {
    lateinit var currentUser: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_)

        val intent = intent
        var temp = intent.getSerializableExtra("User")
        currentUser = temp as User
        tvLoginHistory.text = "Hello Wellcome " + currentUser.userName
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun OnImageClick(view: View) {
        val result=when (view.id){
            R.id.ivElectronics->"Electronics"
            R.id.ivClothing->"Clothing"
            R.id.ivBeauty->"Beauty"
            R.id.ivFood->"Food"
            else->"Not Selected"
        }

        val intent= Intent(this,CategoryList::class.java)
        // intent.putExtra("User",currentUser)
        intent.putExtra("Category",result)
        startActivity(intent)

        //Toast.makeText(this,"You have chosen the $result category of shopping",Toast.LENGTH_LONG).show()
    }

}
