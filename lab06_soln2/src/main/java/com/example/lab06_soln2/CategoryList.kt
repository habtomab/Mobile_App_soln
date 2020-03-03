package com.example.lab06_soln2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category_list.*

class CategoryList : AppCompatActivity() {
    var clothesCategory= arrayOf("Jackets and coats",
        "Trousers and shorts" ,
        "Underwear" ,
        "Suits" ,
        "Skirts and dresses",
        "Shoes, boots and slippers",
        "Parts of shoes, boots and slippers",
        "Sweaters and waistcoats")
    var electronicsCategory= arrayOf("Digital electronics",
        "Analogue electronics",
        "Microelectronics",
        "Circuit design",
        "Integrated circuits",
        "Power electronics",
        "Optoelectronics",
        "Semiconductor devices")
    var foodCategory= arrayOf("Vegetables",
        "Fruits",
        "Grains, Beans and Nuts" ,
        "Meat and Poultry",
        "Fish and Seafood",
        "Dairy Foods")
    var beautyCategory= arrayOf("Electrolysis",
        "Hair bleaching",
        "Laser",
        "Shaving",
        "Sugaring",
        "Threading",
        "Waxing")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        val intent=getIntent()
        val selectedCategory=intent.getStringExtra("Category")
        tvCategoryList.text="List of $selectedCategory"
        val adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
            when(selectedCategory){
                "Food"->foodCategory
                "Beauty"->beautyCategory
                "Clothing"->clothesCategory
                else->electronicsCategory
            }
        )
        lvCategoryList.adapter=adapter
        lvCategoryList.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,
                when(selectedCategory){
                    "Food"->foodCategory.get(parent.getItemIdAtPosition(position).toInt())
                    "Beauty"->beautyCategory.get(parent.getItemIdAtPosition(position).toInt())
                    "Clothing"->clothesCategory.get(parent.getItemIdAtPosition(position).toInt())
                    else->electronicsCategory.get(parent.getItemIdAtPosition(position).toInt())
                }, Toast.LENGTH_SHORT).show()
        }
    }
}
