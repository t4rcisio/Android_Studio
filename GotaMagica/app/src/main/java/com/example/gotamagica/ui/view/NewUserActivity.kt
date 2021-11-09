package com.example.gotamagica.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gotamagica.R


class NewUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        if(supportActionBar != null)
            supportActionBar!!.hide()

    }
}