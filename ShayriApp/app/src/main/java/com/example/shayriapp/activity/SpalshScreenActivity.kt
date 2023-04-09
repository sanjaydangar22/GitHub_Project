package com.example.shayriapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.shayriapp.R

class SpalshScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)


        Handler().postDelayed({
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 1000)
    }
}