package com.example.shayriapp.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayriapp.MyDatabase
import com.example.shayriapp.adpater.CategoryAdapter
import com.example.shayriapp.databinding.ActivityMainBinding
import com.example.shayriapp.modeclass.CategoryModelClass
import kotlin.system.exitProcess

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

        navigationView()
        initView()
    }

    private fun navigationView() {
        mainBinding.imgMenu.setOnClickListener {
            mainBinding.navDrawer.openDrawer(GravityCompat.START)

            mainBinding.linFav.setOnClickListener {
                mainBinding.navDrawer.closeDrawer(GravityCompat.START)
                var intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
            }
            //Shear Link
            mainBinding.linShare.setOnClickListener {
                mainBinding.navDrawer.closeDrawer(GravityCompat.START)
                val ShareIntent = Intent(Intent.ACTION_SEND)
                ShareIntent.type = "text/plain"
                ShareIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "https://play.google.com/store/apps/details?id=com.infinitytechapps.allshayari.hindi.shayari"
                )
                startActivity(ShareIntent)
            }

            //Visit privacy policy define
            mainBinding.txtPrivecy.setOnClickListener{
                mainBinding.navDrawer.closeDrawer(GravityCompat.START)
                var browserIntent = Intent(Intent.ACTION_VIEW)
                browserIntent.data = Uri.parse("https://knowledgeworldiswelth.blogspot.com/2023/04/privacy-and-policy.html");
                startActivity(browserIntent)

            }

            mainBinding.linExit.setOnClickListener {

                exitProcess(0)
            }
        }
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
    private var doubleBackToExitPressedOnce: Boolean=false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}