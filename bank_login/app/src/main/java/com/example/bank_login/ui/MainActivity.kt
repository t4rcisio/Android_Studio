package com.example.bank_login.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bank_login.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null)
            supportActionBar!!.hide()
    }

}