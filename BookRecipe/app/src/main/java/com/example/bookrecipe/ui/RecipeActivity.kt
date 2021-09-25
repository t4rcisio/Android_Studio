package com.example.bookrecipe.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bookrecipe.R

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        if(supportActionBar != null)
            supportActionBar!!.hide()

    }
}