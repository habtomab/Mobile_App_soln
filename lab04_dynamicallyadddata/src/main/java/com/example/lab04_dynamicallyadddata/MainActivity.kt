package com.example.lab04_dynamicallyadddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickAdd(view: View) {

        // Create a new table row.
        val tableRow = TableRow(getApplicationContext())


        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(0,4,4,4)
        tableRow.setLayoutParams(layoutParams)


        //Create the two columns as a TextView Controls
        if (etAndroidVersion.text.toString().isNotEmpty() && etAndroidCodeName.text.toString().isNotEmpty()){
            val tv1= TextView(getApplicationContext())
            tv1.setText(etAndroidVersion.text.toString())
            tv1.layoutParams=layoutParams

            val tv2= TextView(getApplicationContext())
            tv2.setText(etAndroidCodeName.text.toString())
            tv2.layoutParams=layoutParams


            // add values into row by calling addView()
            tv1.setBackgroundColor(getResources().getColor(R.color.myColor))
            tv2.setBackgroundColor(getResources().getColor(R.color.myColor))

            tableRow.addView(tv1)
            tableRow.addView(tv2)
            //tableRow.addView(sp)
        }



        // Finally add the created row row into layout
        tableLayout.addView(tableRow)
    }
}

