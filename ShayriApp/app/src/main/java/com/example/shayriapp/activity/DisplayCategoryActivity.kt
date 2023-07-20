package com.example.shayriapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayriapp.MyDatabase
import com.example.shayriapp.adpater.DisplayCategoryAdapter
import com.example.shayriapp.databinding.ActivityDisplayCategoryBinding
import com.example.shayriapp.modeclass.DisplayCategoryModelClass

class DisplayCategoryActivity : AppCompatActivity() {

    lateinit var displayBinding: ActivityDisplayCategoryBinding  //Activity Binding

    lateinit var dbD: MyDatabase        //Database class Define

    var shariList = ArrayList<DisplayCategoryModelClass>()    //Array list in define Model class
    lateinit var adapter: DisplayCategoryAdapter    //Adapter class Define

    var c_ID: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        displayBinding = ActivityDisplayCategoryBinding.inflate(layoutInflater)
        setContentView(displayBinding.root)    //set Xml File

        dbD = MyDatabase(this)   //Database in set context Class

        initview()
    }

    private fun initview() {

        displayBinding.imgBack.setOnClickListener {                // one activity to second activity move
            onBackPressed()
        }
        displayBinding.imgLike.setOnClickListener {                     // one activity to second activity move
            var fav = Intent(this, FavoriteActivity::class.java)
            startActivity(fav)
        }


        var categoryName: String? = intent.getStringExtra("Title")    // set key data in variable
        displayBinding.txtDisplayTitle.text =
            categoryName                 //variable set in textview

        c_ID = intent.getIntExtra("Id", 0)  // set key data in variable


        adapter = DisplayCategoryAdapter(
            this,
            {   //create adapter class object and pass parameter
                var i = Intent(this, ShayriDishplayActivity::class.java)
                i.putExtra("shariItem", it.shayri_item)
                startActivity(i)
                finish()
            },
            {  fav ,shayri_id->
                dbD.Fav_updateRecord(fav,shayri_id)  //record update

            })

        var mangar = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        displayBinding.rcvCategoryData.layoutManager = mangar
        displayBinding.rcvCategoryData.adapter = adapter


    }

    override fun onResume() {
        super.onResume()
        shariList = dbD.shayriData(c_ID)   //variable set in textview
        adapter.updateList(shariList)

    }
}