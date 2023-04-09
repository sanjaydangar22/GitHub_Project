package com.example.shayriapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayriapp.MyDatabase
import com.example.shayriapp.R
import com.example.shayriapp.modeclass.CategoryModelClass
import com.example.shayriapp.adpater.CategoryAdapter
import com.example.shayriapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding   // Activity Binding

    lateinit var adapter: CategoryAdapter       //Adapter define

    lateinit var db: MyDatabase   //Database define


    var categoryList = ArrayList<CategoryModelClass>()   //Array list in define Model class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)   //set xml file

        db = MyDatabase(this)  //database class in set context class
        initView()
    }

    private fun initView() {

        mainBinding.imgLikePage.setOnClickListener {                    //move to one activity to second activity
            var fav = Intent(this, FavoriteActivity::class.java)
            startActivity(fav)
        }


        categoryList = db.categoryData()                                     //database class define

        adapter =
            CategoryAdapter(categoryList) {      //adapter class object create and pass parameter

                var i = Intent(this, DisplayCategoryActivity::class.java)
                i.putExtra("Title", it.categoryName)
                i.putExtra("Id", it.id)

                Log.e("TAG", "initView: " + it.id)
                startActivity(i)
            }
        var manger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainBinding.rcvCategory.layoutManager = manger
        mainBinding.rcvCategory.adapter = adapter


    }
}