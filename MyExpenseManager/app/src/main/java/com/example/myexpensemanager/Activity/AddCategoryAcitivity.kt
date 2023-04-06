package com.example.myexpensemanager.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexpensemanager.Adapter.AddCategoryAdapter
import com.example.myexpensemanager.CategoryHelper
import com.example.myexpensemanager.ModelClass.CategoryModelClass
import com.example.myexpensemanager.databinding.ActivityAddCategoryBinding

class AddCategoryAcitivity : AppCompatActivity() {

    lateinit var addCategoryBinding: ActivityAddCategoryBinding

    lateinit var adapter: AddCategoryAdapter

    lateinit var dataBase: CategoryHelper
    var list = ArrayList<CategoryModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addCategoryBinding = ActivityAddCategoryBinding.inflate(layoutInflater)
        setContentView(addCategoryBinding.root)

        dataBase = CategoryHelper(this)

        intiView()
    }

    private fun intiView() {
        addCategoryBinding.btnCategoryAdd.setOnClickListener {
            var name = addCategoryBinding.edtAddCategory.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a field", Toast.LENGTH_SHORT).show()
            } else if (name.length <= 3 || name.length >= 15) {
                Toast.makeText(this, "please enter a valid field", Toast.LENGTH_SHORT).show()
            }
            dataBase.insertRecord(name)
            Toast.makeText(this, "Entry Inserted", Toast.LENGTH_SHORT).show()
            list = dataBase.displayRecord()

            adapter = AddCategoryAdapter()
            var manger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            addCategoryBinding.rcvDisplay.layoutManager = manger
            addCategoryBinding.rcvDisplay.adapter = adapter

            adapter.updateData(list)
        }



        addCategoryBinding.imgDone.setOnClickListener {
            val a = Intent(this@AddCategoryAcitivity, HomePageActivity::class.java)
            startActivity(a)
            finish()
        }
        addCategoryBinding.imgBack.setOnClickListener {
            val a = Intent(this@AddCategoryAcitivity, HomePageActivity::class.java)
            startActivity(a)
            finish()
        }


    }
}