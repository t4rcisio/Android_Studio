package com.example.gotamagicaapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        val newAccount = findViewById<TextView>(R.id.newUser)
        newAccount.setOnClickListener {
           startActivity(Intent(applicationContext,CreateUserActivity::class.java))

        }


    }

    override fun onClick(v: View?) {

    }


}