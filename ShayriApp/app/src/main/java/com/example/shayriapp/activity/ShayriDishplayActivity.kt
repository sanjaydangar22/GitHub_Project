package com.example.shayriapp.activity

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.shayriapp.databinding.ActivityShayriDishplayBinding
import java.io.*


class ShayriDishplayActivity : AppCompatActivity() {

    lateinit var shayriBinding: ActivityShayriDishplayBinding   //Activity Binding
    private val STORAGE_PERMISSION_CODE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shayriBinding = ActivityShayriDishplayBinding.inflate(layoutInflater)
        setContentView(shayriBinding.root)    //set xml file


        intiView()
    }

    // Function to check and request permission.
    fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }
    }



    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )
       if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.size > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private fun intiView() {

        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )

        shayriBinding.imgBack.setOnClickListener {   //move to one activity to second activity

            onBackPressed()
        }
        var shariName: String? = intent.getStringExtra("shariItem")    //set key in variable
        shayriBinding.txtShariDisplay.text = shariName                  // variable set in text view

        //save
        shayriBinding.imgSaveD.setOnClickListener {
            val z: View = shayriBinding.relLayout
            z.isDrawingCacheEnabled = true
            val totalHeight: Int = z.height
            val totalWidth: Int = z.width
            z.layout(0, 0, totalWidth, totalHeight)
            z.buildDrawingCache(true)
            val bm: Bitmap = Bitmap.createBitmap(z.getDrawingCache())
            z.isDrawingCacheEnabled = false
            MediaStore.Images.Media.insertImage(contentResolver, bm, null, null)
//            takeScreenshot(this,it)
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