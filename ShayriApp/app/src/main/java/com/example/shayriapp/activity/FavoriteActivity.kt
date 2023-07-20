package com.example.shayriapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayriapp.MyDatabase
import com.example.shayriapp.adpater.FavoriteAdapter
import com.example.shayriapp.databinding.ActivityFavoriteBinding
import com.example.shayriapp.modeclass.FavouriteModelClass

class FavoriteActivity : AppCompatActivity() {

    lateinit var favoriteBinding: ActivityFavoriteBinding   //Activity Binding

    var list = ArrayList<FavouriteModelClass>()    //Array list in define Model class
    lateinit var db: MyDatabase                   //Database class define

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)   //xml file define

        db = MyDatabase(this) //database class in set context class
        initview()
    }

    private fun initview() {

        favoriteBinding.imgBackFav.setOnClickListener {   //move to one activity to second activity
            onBackPressed()
        }
        if (list != null) {
            var adpater =
                FavoriteAdapter { fav, shayri_id ->            //set adapter class and pass parameter
                    db.Fav_updateRecord(
                        fav,
                        shayri_id
                    )                     //set update record in database class

                }
            var manger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            favoriteBinding.rcvFavorite.layoutManager = manger
            favoriteBinding.rcvFavorite.adapter = adpater

            list = db.Fav_DisplayRecord()   //set display record  add array list
            adpater.updateList(list)          //list set adapter class in updateList function
            favoriteBinding.txtNoPost.visibility = View.GONE
        }
    }
}