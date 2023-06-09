package com.example.shayriapp.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.shayriapp.databinding.ActivityShayriDishplayBinding
import java.io.*


class ShayriDishplayActivity : AppCompatActivity() {

    lateinit var shayriBinding: ActivityShayriDishplayBinding   //Activity Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shayriBinding = ActivityShayriDishplayBinding.inflate(layoutInflater)
        setContentView(shayriBinding.root)    //set xml file

        intiView()
    }

    private fun intiView() {
        shayriBinding.imgBack.setOnClickListener {   //move to one activity to second activity

            onBackPressed()
        }
        var shariName: String? = intent.getStringExtra("shariItem")    //set key in variable
        shayriBinding.txtShariDisplay.text = shariName                  // variable set in text view

        shayriBinding.imgSaveD.setOnClickListener {
            var image:View=shayriBinding.relLayout
            image.isDrawingCacheEnabled = true
            val totalHeight:Int=image.height
            val totalWidth:Int=image.width
            image.layout(0,0,totalHeight,totalWidth)
            image.buildDrawingCache(true)
            val data: Bitmap = Bitmap.createBitmap(image.drawingCache)
            image.isDrawingCacheEnabled = false
           MediaStore.Images.Media.insertImage(contentResolver,data,null,null)
            Toast.makeText(this, "save image", Toast.LENGTH_SHORT).show()
        }
        //Shear Link
        shayriBinding.imgShare.setOnClickListener(View.OnClickListener { s: View? ->
            val ShareIntent = Intent(Intent.ACTION_SEND)
            ShareIntent.type = "text/plain"
            ShareIntent.putExtra(Intent.EXTRA_TEXT, shariName)
            startActivity(ShareIntent)
        })

        //copy Shayri
        shayriBinding.imgCopyD.setOnClickListener {
            val clipboard: ClipboardManager =
                getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", shariName)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show()
        }

        //gallery
        shayriBinding.imgAdd.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            gallery_Launcher.launch(intent)
        }
    }

    //gallery
    var gallery_Launcher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val uri = data!!.data
            shayriBinding.imgShow.setImageURI(uri)
        }
    }



}