package com.example.gotamagicaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }
    }
}